package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr=new int[]{1,2,3};
        ArrayList<ArrayList<Integer>> lll=new ArrayList<>();
        Solution s=new Solution();

        System.out.println( s.subsets(arr));
    }
}
