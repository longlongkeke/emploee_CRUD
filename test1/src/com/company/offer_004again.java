package com.company;

import java.util.HashMap;

public class offer_004again {
    public static void main(String[] args) {
        int[] arr=new int[]{2,2,3,2};
        int i = singleNumber(arr);
        System.out.println(i);
    }
    public static int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
                hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }
        for (Integer i:hashMap.keySet()) {
            Integer value = hashMap.get(i);
            if(value==1){
                return i;
            }
        }
        return 0;
    }
}
