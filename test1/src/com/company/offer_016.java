package com.company;

public class offer_016 {
    public static void main(String[] args) {
        int i = lengthOfLongestSubstring("dvdf");
        System.out.println(i);
    }
    public static int lengthOfLongestSubstring(String s) {
        int max=0,len=0;
        int left=0,end=0;
        while (left<s.length()&&end<s.length()){
           if(isre(s.substring(left,end+1))){//有重复的
                left++;
           }else{
               len=end-left+1;
               end++;
               if(max<len) max=len;
           }
        }
        return max;
    }
    public static boolean isre(String s) {
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(s.lastIndexOf(c)!=i) return true;
        }
       return  false;
    }
}
