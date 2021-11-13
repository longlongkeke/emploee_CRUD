package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class offer_084 {
    public static void main(String[] args) {
        int[]nums =new int[] {1,1,3};
        List<List<Integer>> permute = permuteUnique(nums);
        System.out.println(permute);
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res=new ArrayList<>();
            List<Integer> path=new ArrayList<>();
            List<Integer> index=new ArrayList<>();
            backtracing(nums,res,path,0,index);
      //  HashSet hashSet = new HashSet(res);
        return res ;
    }
    public static void backtracing(int[] nums,List<List<Integer>> res,List<Integer> path,int ids,List<Integer> index){

        if(nums.length==path.size()){
            if(!res.contains(new ArrayList<>(path))){//同一个根下面有可能会出现相同的组合。去重。解决方案：res里没有再添加 如果有直接return
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i=ids;i<nums.length;i++){
            if(index.contains(i)){
                continue;
            }
            if(i>0&&path.size()==0&&nums[i]==nums[i-1]){//如果集合中遇到相同元素 就直接跳过 避免重复计算 降低时间复杂度
                continue;
            }
            index.add(i);
            path.add(nums[i]);
            backtracing(nums,res,path,ids,index);
            path.remove(path.size()-1);
            index.remove(index.size()-1);
        }
    }
}
