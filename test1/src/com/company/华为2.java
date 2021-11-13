package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 华为2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w = 0;
        long[] f = new long[10005];
        int[] arr = new int[101];
        int x = 0, m = 0;
        f[0] = 1;
        x = in.nextInt();
        m = in.nextInt();
        for (int p = 0; p < m; p++) {
            arr[p] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            for (int j = x; j >= arr[i]; j--) {
                f[j] += f[j - w];
                System.out.println(w+""+j+""+f[j]);
            }
        }
        if (f[x] != 0) {
            System.out.println(f[x]);
        } else {
            System.out.println(-1);
        }
    }
//        int count=0;
//        int sum=0;
//        List<Integer> path=new ArrayList<>();
//        backtracing(arr,count,0,path,sum);
//        System.out.println(count);
//    }
//    public static void backtracing(int[] arr, int count, int ids, List<Integer> path,int sum){
//        if(sum==25){
//            count++;
//            return;
//        }
//        for(int i=ids;i<arr.length;i++){
//            path.add(arr[i]);
//            for(int j=0;j<path.size();j++){
//                sum+=path.get(j);
//            }
//            backtracing(arr,count,ids+1,path,sum);
//            path.remove(path.size()-1);
//        }
//    }
}
