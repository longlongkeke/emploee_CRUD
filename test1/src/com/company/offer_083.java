package com.company;

import java.util.ArrayList;
import java.util.List;

public class offer_083 {
    public static void main(String[] args) {
        int[]nums =new int[] {1};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        backtracing(nums,res,path,0);
        return res;
    }
    public static void backtracing(int[] nums,List<List<Integer> >res,List<Integer> path,int ids){
        if(nums.length==path.size()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=ids;i<nums.length;i++){
            if(path.contains(nums[i])) continue;
            path.add(nums[i]);
            backtracing(nums,res,path,ids);
            path.remove(path.size()-1);

        }
    }
}
