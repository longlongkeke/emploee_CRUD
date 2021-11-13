package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class leetcode_全排列二 {
    public static void main(String[] args) {
        int[]nums =new int[]{1,1,2};
        List<List<Integer>> lists = permuteUnique(nums);
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res=new ArrayList<>();
            List<Integer> path=new ArrayList<>();
            List<Integer> index=new ArrayList<>();
            Boolean[] used=new Boolean[nums.length];
           for(int i=0;i<used.length;i++){
               used[i]=false;
           }
            backtracing(nums,res,path,used);
            HashSet<List<Integer>> Hashset=new HashSet<>(res);//转为hashset去重 有缺点
            return new ArrayList<>(Hashset);
            // return res;
        }
        public static void backtracing(int[] nums, List<List<Integer>> res, List<Integer> path,Boolean[] used){
            if(path.size()==nums.length){
                res.add(new ArrayList(path));
                return;
            }
            for(int i=0;i<nums.length;i++){
                if(used[i]){
                    continue;
                }
                 if(i>0&&nums[i]==nums[i-1]&&!used[i-1]){
                     continue;
                 }
                path.add(nums[i]);
                used[i]=true;
                backtracing(nums,res,path,used);
                path.remove(path.size()-1);
                used[i]=false;

            }
        }
    }

