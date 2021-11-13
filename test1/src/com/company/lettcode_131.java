package com.company;

import java.util.ArrayList;
import java.util.List;

public class lettcode_131 {
    public static void main(String[] args) {
        List<List<String>> aab = partition("aab");
        System.out.println(aab);
    }
    public static List<List<String>> partition(String s) {
            List<List<String>> res=new ArrayList<>();
            List<String> path=new ArrayList<>();
            backtracing(s,res,path,0);
            return res;
    }
    public static void backtracing(String s,List<List<String>> res,List<String> path,int startIndex){
        if(startIndex==s.length()){//说明找到了一种分割方案
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<s.length();i++){//横向分割
            int t=i+1;
            String substring = s.substring(startIndex, i+1);//从剩余的字符串切割 纵向分割
            if(!ishui(substring)){
                continue;
            }
            path.add(substring);
            backtracing(s,res,path,i+1);//已经切割的不能重复切割了所以加一  纵向分割
            path.remove(path.size()-1);


        }
    }
    public static boolean ishui(String s){
        boolean flag=false;
        int i=0,j=s.length()-1;
        while (i<=j){
            if(s.charAt(i)==s.charAt(j)){
                flag=true;
            }else{
                flag=false;
                return flag;
            }
            i++;
            j--;

        }


        return flag;
    }
}
