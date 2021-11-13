package com.company;

public class offer_032 {
    public static void main(String[] args) {
        boolean anagram = isAnagram("rat", "car");
        System.out.println(anagram);
    }
    public static boolean isAnagram(String s, String t) {
        int[] arr=new int[26];
        if(s.equals(t)){
            return false;
        }else{
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                char ch1=t.charAt(i);
                arr[(int)ch-97]++;
                arr[ch1-'a']--;
            }
            for(int i:arr){
                if(i!=0){
                    return false;
                }
            }

        }
        return false;
    }
}
