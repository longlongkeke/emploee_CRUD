package com.company;

import java.util.*;

public class leetcode_15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length==1||nums.length==0){
            return  res;
        }
        Arrays.sort(nums);
        int j=1,k;
        for(int i=0;i<nums.length;i++){
            j=i+1;
            k=nums.length-1;
            while (j<k){
                int i1 = nums[i] + nums[j] + nums[k];
                if(i1>0){
                    k--;
                }
                if(i1<0)
                {
                    j++;
                }
                if(i1==0){
                    List<Integer> path = new ArrayList<>();
                    path.add(nums[i]);
                    path.add(nums[j]);
                    path.add(nums[k]);
                    res.add(new ArrayList<>(path));
                    j++;
                    k--;
                }
            }
        }
        HashSet<List<Integer>> hashSet=new HashSet<>(res);

        return new ArrayList<>(hashSet);
        //HashSet<List<Integer>> hashSet = new HashSet<>(res);
       // return new ArrayList<>(hashSet);
    }
}