package com.company;

public class offer_019 {
    public static void main(String[] args) {
        boolean abca = validPalindrome("abca");
        System.out.println(abca);
    }
    public static boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                String str=del(s,i);
                String str1=del(s,j);
                if(isPalindrome(str)||isPalindrome(str1)){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public static String del(String s,int i){
        String substring = s.substring(0, i);
        String substring1 = s.substring(i+1, s.length());
        return s.substring(0,i)+s.substring(i+1,s.length());
    }
    public static boolean isPalindrome(String s){
        StringBuffer buffer=new StringBuffer(s);
         buffer.reverse();
        String s1 = buffer.toString();
        if(s1.equals(s)){
            return true;
        }
        return false;
    }
}
