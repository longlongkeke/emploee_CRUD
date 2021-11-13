package com.company;
import java.util.Scanner;
public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = scanner.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n; i++){
            int sum = array[i];
            for(int j = i + 1; j < n; j++){
                sum = sum & array[j];
                if(sum == 0) res++;
            }
        }
        System.out.println(res);
    }
    }

