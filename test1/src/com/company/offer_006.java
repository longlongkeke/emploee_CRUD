package com.company;

public class offer_006 {
    public static void main(String[] args) {
        int arr[]=new int[]{1,2,4,6,10};
        int[] ints = twoSum(arr, 8);
        System.out.println(ints);
    }
    public static int[] twoSum(int[] numbers, int target) {
        int temp=0;
        int []arr=new int[2];
        for(int i=0;i<numbers.length-1;i++){
            temp=target-numbers[i];
            int re = search(numbers, i + 1,temp);
            if(re!=-1){
                arr[0]=i;
                arr[1]=re;
                return arr;
            }
        }
        return arr;
    }
    public  static int search(int[] nums, int left1,int target){
        int left = left1;
        int right = nums.length - 1; // 注意
        while(left <= right) { // 注意
            int mid = (right + left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }
}
