package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class offer_085 {
    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println(list);
    }
    public static List<String> generateParenthesis(int n) {
        StringBuilder path=new StringBuilder();
        LinkedList<String> res=new LinkedList<>();
        Character[] nums=new Character[]{'(',')'};
        dfs(n,res,path,nums,0,0,0);
        return res;
    }
    public static void dfs(int n,LinkedList<String> res,StringBuilder path,Character[] nums,int ids,int count1,int count2){//减枝：一旦闭括号数量大于开括号 就减枝
        if(path.length()==2*n&&count1==count2&&count1==n&&count2==n&&path.charAt(path.length()-1)!='('&&path.charAt(0)!=')') {
            res.add(path.toString());
        }
        if(path.length()==2*n){
            return;//回溯
        }
        if(count1<count2){
            return;
        }


        for(int i=0;i<nums.length;i++){
            int Count1=0;
            int Count2=0;

//            if(Count1!=Count2&&Count1==2&&Count2==2) break;
            path.append(nums[i]);
            for(int j=0;j<path.length();j++){
                if(path.charAt(j)=='('){
                    Count1++;
                }
            }
            for(int j=0;j<path.length();j++){
                if(path.charAt(j)==')'){
                    Count2++;
                }
            }
            dfs(n,res,path,nums,ids,Count1,Count2);
            path.deleteCharAt(path.length()-1);
        }
    }
//public  static List<String> generateParenthesis(int n) {
//    List<String> res = new ArrayList<>();
//    if (n <= 0) return res;
//    dfs(n, "", res, 0, 0);
//    return res;
//}
//
//    private static void dfs(int n, String path, List<String> res, int open, int close) {
//        if (open > n || close > open) return;
//
//        if (path.length() == 2 * n) {
//            res.add(path);
//            return;
//        }
//
//        dfs(n, path + "(", res, open + 1, close);
//        dfs(n, path + ")", res, open, close + 1);
//    }


}
