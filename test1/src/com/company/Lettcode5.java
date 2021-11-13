package com.company;
//最长回文子串
public class Lettcode5 {
    public static void main(String[] args) {
        String cbbd = longestPalindrome("cbbd");
        System.out.println(cbbd);
    }
    public static String longestPalindrome(String s) {
        char ch[]=s.toCharArray();
        int left,right;
        int len=1;
        int maxlen=0;
        int maxstart=0;
        for(int i=0;i<s.length();i++){
            left=i-1;
            right=i+1;
            while(left>=0&&ch[i]==ch[left]){
                left--;
                len++;
            }
            while(right<s.length()&&ch[i]==ch[right]){
                right++;
                len++;
            }
            while(left>=0&&right<s.length()&&ch[right]==ch[left]){
                left--;
                right++;
                len+=2;
            }
            if(len>maxlen){
                maxlen=len;
                maxstart=left;
            }
            len=1;
        }
        return s.substring(maxstart+1,maxstart+maxlen+1);
    }
}
