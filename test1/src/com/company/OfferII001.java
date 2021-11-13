package com.company;

public class OfferII001 {
    public static void main(String[] args) {
        System.out.println(divide(2147483647,2));
    }
    public static int divide(int a, int b) {
        if(a==0){
            return 0;
        }
        if(a==-Math.pow(2,31)&&b==-1){
            return (int) (Math.pow(2,31)-1);
        }
        int flag=0;
//         if((a*b)>0){
//             flag=0;
//         }else{
//             flag=1;
//
//         }
        if(a>0&&b>0){
            flag=0;
        }else{
            flag=1;
        }
         a=(a>0)?-(a):a;
         b=(b>0)?-(b):b;
        int count=0;
        while(a<=b){
            a=a-b;
            count++;
        }
        return flag==1?-(count):count;

    }
}
