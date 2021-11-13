package com.company;

public class offer_068 {
    public static void main(String[] args) {
      int[] nums =new int[] {1};
      int target = 0;
        int i = searchInsert(nums, target);
        System.out.println(i);
    }
    public static int searchInsert(int[] nums, int target) {
                int left=0,right=nums.length-1;
                while (left<=right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] == target) {
                        return mid;
                    } else if (nums[mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                return left;

        }

    }

