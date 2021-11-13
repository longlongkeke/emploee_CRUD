package com.company;

import java.util.Scanner;

public class zuixiaogongweishu {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int min=0;
        if(a>b){
            min=b;
        }else{
            min=a;
        }
        int re=1;
        for (int i=2;i<=min;i++){
            while (a%i==0&&b%i==0){
                re=re*i;
                a=a/i;
                b=b/i;
            }
        }
        System.out.println(re*a*b);

    }
}
