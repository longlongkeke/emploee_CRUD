package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class offer_086 {
    public static void main(String[] args) {
        List<List<String>> googles = partition("cdd");
        System.out.println(googles);
    }
    public static List<List<String>> partition(String s) {
        String[][] arr=new String[s.length()][s.length()];
        String[] path=new String[s.length()];
        List<List<String>> res=new LinkedList<>();
        List<String> path1=new LinkedList<>();
        int k=0;
        int row=0;
        char[] ch=s.toCharArray();
        List<String> list1=new ArrayList<>();
        for (Character item:ch) {
            list1.add(item.toString());
        }
        res.add(list1);
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(ishui(i,j,s)){
                    String substring = s.substring(i, j + 1);
                    int tempi=i;
                    // path[tempi]=substring;//将回文子字符串添加到字符串数组中
                    if(path1.size()==0){
                        path1.add(tempi,"");
                    }
//                    path1.add(tempi,substring);
                    path1.set(tempi,substring);
                    for(int m=j+1;m<s.length();m++){//将剩余的字符添加到字符串数组中
                        path1.add(++tempi,s.charAt(m)+"");
                        //path[++tempi]=s.charAt(m)+"";
                    }
                    for(int left=i-1;left>=0;left--){
                        char c = s.charAt(left);
//                        path1.add(left,c+"");
                        path1.set(left,c+"");
                    }
                    List<String> temp=new LinkedList<>();//复制一份path1到res
                    for(int sss=0;sss<path1.size();sss++){
                        temp.add(path1.get(sss));
                    }
                    res.add(temp);
//                    for(int ss=0;ss<path.length;ss++){
//                        path[ss]="";
//                    }
                    for(int sssss=0;sssss<path1.size();sssss++){
                        path1.set(sssss,"");
                    }
                    break;
                }
            }
        }
        // for(int ssss=0;ssss<res.size();ssss++){
        //     List<String> list = res.get(ssss);
        //     String[] arryay = (String[]) list.toArray();
        //     arr[ssss]=arryay;

        // }
//        int length = path1.size();//检查二维数组的每一行是否有null
//        for(int yy=length-1;yy>=0;yy--){
//            for(int xx=arr[0].length-1;xx>=0;xx--){
//                if(arr[yy][xx]==null){
//                    String[][] copy3 = Arrays.copyOf(arr, arr.length - 1);
//                    arr=copy3;
//                    break;
//
//                }
//            }
//
//        }
//        int length1 = arr[0].length;//检查二维数组的每一行是否有""
//
//        for(int xx=arr[0].length-1;xx>=0;xx--){
//            if(arr[0][xx].equals("")){
//                String[][] copy3 = Arrays.copyOf(arr, arr.length - 1);
//                arr=copy3;
//                break;
//
//            }
//        }
        return res;

    }
    public static boolean ishui(int i,int j,String s){
        boolean flag=false;

        while (i>=0&&j>=0&&i<j){
            if(s.charAt(i)==s.charAt(j)){
                flag=true;
                i++;
                j--;
            }else{
                flag=false;
                return flag;
            }

        }


        return flag;
    }
}
