package com.company;

public class offer_018 {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(".,");
        System.out.println(palindrome);
    }
    public static boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        int ishefa1=0;
        int ishefa2=0;
        boolean flag=true;
        while(i<=j){
            char c=' ';
            char c1=' ';
            while (i<s.length()){
                c=s.charAt(i);

                if(c>=48&&c<=57||c>=65&&c<=90||c>=97&&c<=122){//判断是否合法
                    ishefa1=1;
                    break;
                }else{
                    i++;
                }
            }
            while (j>=0) {
                c1=s.charAt(j);
                if (c1 >= 48 && c1 <= 57 || c1 >= 65 && c1 <= 90 || c1 >= 97 && c1 <= 122) {//判断是否合法
                    ishefa2 = 1;
                    break;
                } else {
                    j--;
                }
            }
            if(i==j){
                flag=true;
            }
            if(i<=s.length()&&j>=0){
                if(s.charAt(i)<=90&&s.charAt(i)>=65&&s.charAt(j)>=48&&s.charAt(j)<=57||s.charAt(j)<=90&&s.charAt(j)>=65&&s.charAt(i)>=48&&s.charAt(i)<=57){
                    return false;
                }
            }

            if(ishefa1==1&&ishefa2==1){
                if(s.charAt(i)==s.charAt(j)||Math.abs(s.charAt(i)-s.charAt(j))==32){//比较两个字符是否相等
                    flag=true;//继续比较
                    i++;
                    j--;
                }else{
                    return false;
                }
            }

        }
        return flag;

    }
}
