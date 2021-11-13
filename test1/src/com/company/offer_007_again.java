package com.company;

import java.util.*;

public class offer_007_again {
    public static void main(String[] args) {
        int[]arr=new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(arr);
        System.out.println(lists);

    }
    public static List<List<Integer>> threeSum(int[] arr) {
        LinkedList<Integer> list=new LinkedList<>();
        //   HashSet<List<Integer>> re=new HashSet<>();
        // Arrays.sort(nums);
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         for(int k=j+1;k<nums.length;k++){
        //             if(nums[i]+nums[j]+nums[k]==0){
        //                 List<Integer> integers = Arrays.asList(nums[i], nums[j], nums[k]);
        //                 re.add(integers);
        //             }
        //         }
        //     }
        // }
        // List<List<Integer>> res=new ArrayList<>(re);
        // return res;//超时  时间复杂度：n的三次方
        Set<List<Integer>> re=new HashSet<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length-2;i++){
            if(i>0&&arr[i]==arr[i-1]){
                continue;
            }
            int left=i+1;
            int end=arr.length-1;
            while (left<end){
                int sum=arr[left]+arr[end];
                if(sum==-arr[i]){
                    re.add(Arrays.asList(arr[i],arr[left],arr[end]));

                    while (left < end) {
                        // 不管前后相不相等，left 都要往前走
                        left++;
                        if (arr[left - 1] != arr[left]) break;
                    }
                    while (left < end) {
                        // 不管前后相不相等，right 都要往后走
                        end--;
                        if (arr[end + 1] != arr[end]) break;
                    }
                }else if(sum>-arr[i]){
                    end--;
                }else{
                    left++;
                }
            }
        }
        return new ArrayList<List<Integer>>(re);
    }
//    public static List<List<Integer>> threeSum(int[] nums) {
//        if (nums == null || nums.length < 3)
//            return new ArrayList<>();
//
//        List<List<Integer>> res = new ArrayList<>();
//
//        Arrays.sort(nums); // O(nlogn)
//
//        // O(n^2)
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (i > 0 && nums[i] == nums[i - 1]) continue;
//            // 在 i + 1 ... nums.length - 1 中查找相加等于 -nums[i] 的两个数
//            int target = -nums[i];
//            int left = i + 1;
//            int right = nums.length - 1;
//            while (left < right) {
//                int sum = nums[left] + nums[right];
//                if (sum == target) {
//                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
//                    // 去重
//                    while (left < right && nums[left] == nums[++left]);
//                    while (left < right && nums[right] == nums[--right]);
//                } else if (sum < target) {
//                    left++;
//                } else {
//                    right--;
//                }
//            }
//        }
//
//        return res;
//    }

}
