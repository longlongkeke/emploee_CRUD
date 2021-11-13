package com.company;

import java.util.ArrayList;
import java.util.List;

public class offer_087 {
    public static void main(String[] args) {
        List<String> list = restoreIpAddresses("25525511135");
        System.out.println(list);
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<>();
        StringBuilder path=new StringBuilder();
        backtracing(s,res,path,0);
        return res;

    }
    public  static void backtracing(String s,List<String> res,StringBuilder path,int startIndex){
        int count=0;
        if(count==3){
            res.add(path.toString());
            return;
        }

        for(int i=startIndex;i<s.length();i++){

            if(Integer.parseInt(s.substring(startIndex,i+1))>255||Integer.parseInt(s.substring(startIndex,i+1))<0) continue;
            path.append(s.substring(startIndex,i+1));
            path.append(".");
            for(int j=0;j<path.length();j++){
                boolean b = path.charAt(j) == '.';
                if(b){
                    count++;
                }
            }
            backtracing(s,res,path,i+1);
            path.delete(i,path.length()-1);

        }
    }
}
