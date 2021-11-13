package com.company;

public class test4 {
    public int reverse(int x) {
        String str=""+x;
        StringBuilder b=new StringBuilder(str);
        StringBuilder c=new StringBuilder();
        String str1="";
        int i;
        if(x>=0){
            str1=b.reverse().toString();
            return Integer.valueOf(str1).intValue();
        }else{
            c=b.deleteCharAt(0);
            str1=c.reverse().toString();
            i=Integer.valueOf(str1).intValue();
            i=i*(-1);
            return i ;
        }


    }

    public static void main(String[] args) {
        test4 t=new test4();
        int re=0;
        re=t.reverse(123456789);
        System.out.println(re);
    }
}
