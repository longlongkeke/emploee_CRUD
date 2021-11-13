package com.company;

import java.util.ArrayList;

public class leetcode213 {
    public static void main(String[] args) {
        int arr[]=new int[]{200,3,140,20,10};
        System.out.println(rob(arr)) ;
    }
    public static int rob(int[] nums) {
        int len=nums.length;
        if(nums.length==1){
            return nums[0];
        }else if(len==2){
            return Math.max(nums[0],nums[1]);
        }else{
            return Math.max(Maxfee(nums,0,len-1),Maxfee(nums,1,len));
        }


    }
    public static int Maxfee(int[] nums,int start,int len){
        int first=nums[start],second=Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<len;i++){
            int temp=second;
            second=Math.max(first+nums[i],second);
            first=second;
        }
        return second;

    }



}
