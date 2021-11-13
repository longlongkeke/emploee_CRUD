package com.company;

import java.util.HashMap;
import java.util.Map;

public class offer_004 {
    public static void main(String[] args) {
        int[] arr=new int[]{2,2,3,2};
        int i = singleNumber(arr);
        System.out.println(i);
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey(), occ = entry.getValue();
            if (occ == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }
}
