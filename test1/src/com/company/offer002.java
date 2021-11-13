package com.company;

public class offer002 {
    public static void main(String[] args) {
        String s = addBinary("1", "111");
        System.out.println(s);
    }
    public static String addBinary(String a, String b) {
        int len1=a.length();
        int len2=b.length();
        int jinwei=0;
        String str="";
        int i=len1-1;
        int j=len2-1;
        int max = Math.max(len1, len2);
        while (i>=0||j>=0){
            int i1 = i>=0?Integer.parseInt(a.charAt(i) + ""):0;
            int i2 = j>=0?Integer.parseInt(b.charAt(j) + ""):0;

            String s = (i1 + i2) % 2 + "";
            str=str.concat((i1+i2+jinwei)%2+"");
            jinwei=(i1+i2+jinwei)/2;
            i--;
            j--;
        }
        String concat="";
        if(jinwei!=0){
            concat = str.concat(jinwei+"");
        }

        StringBuffer buffer=new StringBuffer(concat);
        String str1= String.valueOf(buffer.reverse());

        return str1;
    }
}
