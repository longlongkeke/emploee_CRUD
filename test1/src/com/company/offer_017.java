package com.company;
//给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
//
//        如果 s 中存在多个符合条件的子字符串，返回任意一个。
//
//         
//
//        注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
//
//         
//
//        示例 1：
//
//        输入：s = "ADOBECODEBANC", t = "ABC"
//        输出："BANC"
//        解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C'


public class offer_017 {
    public static void main(String[] args) {
        String s = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
    public static String minWindow(String s, String t) {//是否包含另外一个字符串的变位词和包含另外一个字符串的所有字符是一个意思 跟015 014的题里面的变位词是一个意思
        int[] count=new int[60];
        int left=0,end=0;
        int st=0;
        for(int i=0;i<t.length();i++){
            count[t.charAt(i)-'A']++;
            count[s.charAt(i)-'A']--;
        }
        if(islessequalszero(count)) return s.substring(st,t.length());
        int min=Integer.MAX_VALUE;
        int len=0;

        String str="";
        String minstr="";
       for(int i=t.length();i<s.length();++i){
           count[s.charAt(i)-'A']--;
           while (islessequalszero(count)) {
               int length = i-st+1;
               if(length<min){
                   min=length;
                   str=s.substring(st,st+min);
               }
               count[s.charAt(st)-'A']++;
               st++;


           }
       }


        return str;

    }
    public static boolean islessequalszero(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0)return false;
        }
        return true;
    }
}
