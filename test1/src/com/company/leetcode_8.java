package com.company;

public class leetcode_8 {
    public static void main(String[] args) {
        int i = myAtoi(" ");
        System.out.println(i);
    }
    public static int myAtoi(String s) {
        int last=0;
        int sym=1;
        int re=0;
        int index=0;
        while (s.charAt(index)==' '){
            index++;
            continue;
        }
        if(s.charAt(index)=='-'){
            index++;
            sym=sym*(-1);
        }
        if(s.charAt(index)=='+'){
            index++;
        }
        for(int i=index;i<s.length();i++){

            if(s.charAt(i)>=48&&s.charAt(i)<=57){
                last=re;
                re=re*10+s.charAt(i)-'0';
                if(last!=re/10){
                    re=sym==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
                }
            }else{
                break;
            }
        }

        return re*sym;
    }
}
