package com.company;

public class leetcode_509 {
    public static void main(String[] args) {
        int fib = fib(3);
        System.out.println(fib);
    }
    public static int fib(int n) {
        int arr[]=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];

        }
        return arr[n];
    }
}
