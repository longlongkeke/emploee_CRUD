package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.*;

public class offer_086_again {
    public static void main(String[] args) {
        String[][] googles = partition("google");
        System.out.println(googles);
        for(int i=0;i<googles.length;i++){
            for(int j=0;j<googles.length;j++){
                System.out.print(googles[i][j]);
            }
            System.out.println();
        }
    }
    public static String[][] partition(String s) {
        String[][] arr=new String[s.length()][s.length()];
        String[] path=new String[s.length()];
        int k=0;
        int row=0;
        int Count_row=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(ishui(i,j,s)){
                    String substring = s.substring(i, j + 1);
                    int tempi=i;
                    path[tempi]=substring;//将回文子字符串添加到字符串数组中
                    for(int m=j+1;m<s.length();m++){//将剩余的字符添加到字符串数组中
                        path[++tempi]=s.charAt(m)+"";
                    }
                    for(int left=i-1;left>=0;left--){
                        char c = s.charAt(left);
                        path[left]=c+"";
                    }
                    String[] temp=new String[s.length()];
                    for(int sss=0;sss<path.length;sss++){
                        temp[sss]=path[sss];
                    }

                    arr[row++]=temp;
                    Count_row++;
                    int currentrow=--row;
//                    System.out.print("之前：");
//                    for(int item=0;item<arr[currentrow].length;item++){
//
//                        System.out.print(arr[currentrow][item]);
//                    }
                     int n=temp.length-1;
                    while (n>=0){//删除字符是null
                        int length = arr[currentrow].length;
                        if(arr[currentrow][n]!=null&&arr[currentrow][n].equals("")){
                            String[] copy5 = Arrays.copyOf(arr[currentrow], arr[currentrow].length - 1);
                            arr[currentrow]=copy5;
                            n--;
                        }
                       if( arr[currentrow][n]==null) {
                           String[] copy1 = Arrays.copyOf(arr[currentrow], arr[currentrow].length - 1);
                           arr[currentrow]=copy1;
                       }

                        n--;
                    }
//                    System.out.print("之后：");
//                    for(int item=0;item<arr[currentrow].length;item++){
//
//                        System.out.print(arr[currentrow][item]);
//                    }
//                    int n=temp.length-1;
//                    while(temp[n].equals("")&&n>=0){
//                        int len=temp.length;
//                        len--;
//                        n--;
//                    }
                    for(int ss=0;ss<path.length;ss++){
                        path[ss]="";
                    }
                    row++;
                    break;
                }
            }
        }
        int length = arr.length;//检查二维数组的每一行是否有null
        for(int yy=length-1;yy>=0;yy--){
            for(int xx=arr[0].length-1;xx>=0;xx--){
                if(arr[yy][xx]==null){
                        String[][] copy3 = Arrays.copyOf(arr, arr.length - 1);
                        arr=copy3;
                        break;

                }
            }

        }
        int length1 = arr[0].length;//检查二维数组的每一行是否有""

            for(int xx=arr[0].length-1;xx>=0;xx--){
                if(arr[0][xx].equals("")){
                    String[][] copy3 = Arrays.copyOf(arr, arr.length - 1);
                    arr=copy3;
                    break;

                }
            }
        for(int xx=arr[0].length-1;xx>=0;xx--){
            if(arr[1][xx].equals("")){
                String[][] copy3 = Arrays.copyOf(arr, arr.length - 1);
                arr=copy3;
                break;

            }
        }
        //将字符串中的每一个字符单独切割
        List<String> spp=new ArrayList<>();
        for(int sp=0;sp<s.length();sp++){
                spp.add(s.charAt(sp)+"");
        }
        String[] r=new String[spp.size()];
        for(int kk=0;kk<spp.size();kk++){
            r[kk]=spp.get(kk);
        }
        String[][] copy5 = Arrays.copyOf(arr, arr.length +1);
        copy5[copy5.length-1]=r;
        arr=copy5;
        return arr;

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
