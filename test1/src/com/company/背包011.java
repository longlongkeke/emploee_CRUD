package com.company;

import java.util.Scanner;

public class 背包011 {
    public static void MaxValue(int[] v,int[]w,int C,int n){
        int[] dp=new int[C+1];
        for(int i=1;i<=n;i++){
//            for(int j=w[i];j<=C;j++){
//                dp[j]=Math.max(dp[i-1],dp[j-w[i]]+v[i]);
//            }
            for(int j=C;j>=w[i];j--){
                dp[j]=Math.max(dp[i-1],dp[j-w[i]]+v[i]);
            }
        }
        System.out.println(dp[C]);

    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int C=input.nextInt();
        int[] w=new int[n+1];
        int[] v=new int[n+1];
        for(int i=1;i<w.length;i++){
            w[i] = input.nextInt();
        }
        for(int i=1;i<v.length;i++){
            v[i] = input.nextInt();
        }
        MaxValue(v,w,C,n);
    }
}
