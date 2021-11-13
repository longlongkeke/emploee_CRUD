package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lettcode_offer {
    public static void main(String[] args) {
//        Scanner input =new Scanner(System.in);
//        int len = input.nextInt();
//        int arr[]=new int[len];
//        int i=0;
//        while (input.hasNext()){
//          arr[i]= input.nextInt();
//          i++;
//          if(arr.length==len){
//              int target = input.nextInt();
//          }
//
//        }
//        System.out.println(arr);
        int arr[]=new int[]{2,3};
        List<List<Integer>> lists = combinationSum(arr, 7);
        System.out.println(lists);

    }
        public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            List<Integer> combine = new ArrayList<Integer>();
            dfs(candidates, target, ans, combine, 0);
            return ans;
        }

        public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
            if (idx == candidates.length) {
                return;
            }
            if (target == 0) {
                ans.add(new ArrayList<Integer>(combine));
                return;
            }
            // 直接跳过
            dfs(candidates, target, ans, combine, idx + 1);
            // 选择当前数
            if (target - candidates[idx] >= 0) {
                combine.add(candidates[idx]);
                dfs(candidates, target - candidates[idx], ans, combine, idx);
                combine.remove(combine.size() - 1);
            }
        }
    }

