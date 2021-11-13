package com.company;

public class leetcode_1137 {
    public static void main(String[] args) {
        tribonacci(4);
    }
    public static int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        int arr[]=new int[n+1];
        for(int i=3;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
        }
        return arr[n];
    }
}
