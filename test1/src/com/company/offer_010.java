package com.company;
//给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
//
//         
//
//        示例 1 :
//
//        输入:nums = [1,1,1], k = 2
//        输出: 2
//        解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
//        示例 2 :
//
//        输入:nums = [1,2,3], k = 3
//        输出: 2
public class offer_010 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,1,1};
        int i = subarraySum(nums, 2);
        System.out.println(i);
    }
    public static int subarraySum(int[] nums, int k) {
        int left=0;
        int right=0;
        int count=0;
        int num=0;
      while (left<nums.length){
          num+=nums[right];
          while (right<nums.length&&num<k){
              if(left==nums.length-1&&right==nums.length-1){
              if(nums[right]==k){
                  count++;
                  break;
              }
          }
             right++;
             if(right==nums.length)break;
              num+=nums[right];
          }

          if(num>k){
              num=0;
              left++;
          }
          if(num==k){
              num=0;
              count++;
              left++;
          }

      }
       return count;
    }
}
