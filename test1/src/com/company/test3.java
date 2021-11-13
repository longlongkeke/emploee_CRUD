package com.company;

public class test3 {
    public boolean isPalindrome(int x) {
        String str=""+x;
        char[] ch=str.toCharArray();
        boolean flag=false;
       int i=0,j=ch.length-1;
       while(i<j){
           if(ch[i]==ch[j]){
               i++;
               j--;
               flag=true;
           }else{
              flag=false;
           }
       }
        return flag;
    }

    public static void main(String[] args) {
        test3 t=new test3();
        System.out.println( t.isPalindrome(1231));

    }
}
