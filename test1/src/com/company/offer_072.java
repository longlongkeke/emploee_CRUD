package com.company;

public class offer_072 {
    public static void main(String[] args) {
//        double sqrt = Math.sqrt(8);
//        System.out.println((int)(sqrt));
//        System.out.println((float) (sqrt));
        int i = mySqrt(6);
        System.out.println(i);
    }
    public static int mySqrt(int x) {
        // double i=Math.sqrt(x);
        // return (int)i;
        int re=0;
//        for(int i=1;i<=x/2;i++){
//            if(i*i<x){
//                continue;
//            }
//            if(i*i==x){
//                re=i;
//            }
//            if(i*i>x){
//                re=i-1;
//            }
//
//        }
        int left=1,rigth=x;
        int mid=0;
        while(left<=rigth){
            mid=(left+rigth)/2;
            if(x/mid==mid){
                return mid;
            }else if(x/mid>mid){
                left=mid+1;
            }else if(x/mid<mid){
                rigth=mid-1;
            }
        }

        return rigth;
    }
}
