package com.company;

public class offer_008 {
    public static void main(String[] args) {
        int arr[]=new int[]{2,3,1,2,4,3};
        int i = minSubArrayLen(7, arr);
        System.out.println(i);
    }
    public static int minSubArrayLen(int target, int[] nums) {

        int left=0;
        int len=0;
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int right=0;right<nums.length;right++){//右指针
            sum+=nums[right];
            while(sum>=target){//如果和大于等于目标值 计算长度
                len=right-left+1;
                if(min>len){
                    min=len;
                }
                sum-=nums[left];
                left++;

            }

        }
        return min==Integer.MAX_VALUE?0:min;




    }
}
