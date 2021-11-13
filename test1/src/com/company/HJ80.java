package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ80 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            int a=input.nextInt();
            int[] arr=new int[a];
            for(int i=0;i<a;i++){
                arr[i]=input.nextInt();
            }
            int b=input.nextInt();
            int[] arr1=new int[b];
            for(int i=0;i<b;i++){
                arr1[i]=input.nextInt();
            }
            Set<Integer> set=new HashSet<>();
            int i=0,j=0;
            while(i<arr.length||j<arr.length){
                if(i==arr.length){
                    set.add(arr1[j++]);
                }else if(j==arr1.length){
                    set.add(arr[i++]);
                }else if(arr[i]<arr1[j]){
                    set.add(arr[i]);
                    i++;
                }else{
                    set.add(arr1[j]);
                    j++;
                }
            }
            for(Integer item:set){
                System.out.print(i);
            }

        }
    }
}
