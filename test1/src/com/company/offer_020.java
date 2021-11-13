package com.company;

public class offer_020 {
    public static void main(String[] args) {
        int i = countSubstrings("abc");
        System.out.println(i);
    }
    public static int countSubstrings(String s) {
        int num=0;
        for(int i=0;i<s.length();i++) {
            num+=count(s,i,i);//奇数
            num+=count(s,i,i+1);//偶数
        }
        return num;
    }

    public static int count(String s,int i,int j){
        int ans=0;
       while (i>=0&&j<s.length()){
           if(s.charAt(i)==s.charAt(j)){
               ans++;
               j++;
               i--;
           }else{
               break;
           }
       }
        return ans;
    }
}
