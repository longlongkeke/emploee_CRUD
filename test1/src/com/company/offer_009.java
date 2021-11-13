package com.company;

import java.util.ArrayList;
import java.util.List;

public class offer_009 {
//    给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。
//
//             
//
//    示例 1:
//
//    输入: nums = [10,5,2,6], k = 100
//    输出: 8
//    解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//    需要注意的是 [10,5,2] 并不是乘积小于100的子数组。

    public static void main(String[] args) {
        int[] nums=new int[]{10,5,2,6};
        int i = numSubarrayProductLessThanK(nums, 100);
        System.out.println(i);
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1){
            return 0;
        }
        int left=0,end=0;
        int flag=0;
        int count=0;
            int mult=1;
            while (end<nums.length){//
                if(flag==0){
                    mult*=nums[end];
                }
                //mult=k/nums[left];
                if(mult<k){
                    count+=end-left+1;
                    end++;
                    flag=0;
                }else{//不符合条件
                    mult/=nums[left];
                    left++;
                    flag=1;

                }
            }


        return count;
    }
//    public static int numSubarrayProductLessThanK(int[] nums, int k) {
//            int count=0;
//            List<Integer> path=new ArrayList<>();
//            int temp=1;
//            backtracing(count,nums,k,0,path,temp);
//            return count;
//    }
//    public static void backtracing(int count,int[] nums,int k,int strartIndex,List<Integer> path,int temp){
//        if(strartIndex==nums.length){//回溯
//            return;
//        }
//        for(int i=strartIndex;i<nums.length;i++){
//            path.add(nums[i]);
//            temp=1;
//            for (Integer item:path) {
//                temp*=item;
//            }
//            if(temp<k){//减支
//                count++;//做选择
//                backtracing(count,nums,k,strartIndex+1,path,temp);//递归 继续往下走
//            }else{
//                break;
//            }
//            path.remove(path.size()-1);
//
//
//
//        }
//    }

}
