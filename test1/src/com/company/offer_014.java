package com.company;

import java.util.HashMap;

public class offer_014 {
    public static void main(String[] args) {
        boolean b = checkInclusion("a", "ab");
        System.out.println(b);
    }
    public static boolean checkInclusion(String s1, String s2) {
        int[] arr=new int[26];
        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i)-'a']++;
            arr[s2.charAt(i)-'a']--;
        }
        //判断第一个窗口是否是变位词
        boolean isallzero = isallzero(arr);
        if(isallzero) return true;
        for(int j=s1.length();j<s2.length();j++){
            arr[s2.charAt(j)-'a']--;
            arr[s2.charAt(j-s1.length())-'a']++;
            if(isallzero(arr)) return true;
        }
        return false;

    }
    public static boolean isallzero(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }

}
