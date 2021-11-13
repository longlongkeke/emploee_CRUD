package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class offer_007 {
    public static void main(String[] args) {
        int[]nums =new int[] {-1,0,1,2,-1,-4};
        HashSet<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
    public static HashSet<List<Integer>>threeSum(int[] nums) {
        HashSet<List<Integer>> re=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> integers = Arrays.asList(nums[i], nums[j], nums[k]);
                        re.add(integers);
                    }
                }
            }
        }
        return re;
    }
}
