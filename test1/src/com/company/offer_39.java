package com.company;

import java.util.*;

public class offer_39 {
    public static int count=0;
    public static void main(String[] args) {
        int[] arr=new int[]{2,5,2,1,2};
        int target = 5;
        List<List<Integer>> lists = combinationSum(arr, target);
        System.out.println(lists);
        System.out.println(count);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
      //  List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> res=new HashSet<>();
        Arrays.sort(candidates); // 先进行排序
        backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
        return new ArrayList<>(res);
    }

    public static void backtracking(Set<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int idx) {
       ;
        count++;
        // 找到了数字和为 target 的组合
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(res, path, candidates, target, sum + candidates[i], i+1);
            path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素 最后一个元素的回溯没有用 即path中的和不可能为target，那就换下一个的元素
        }
    }


}
