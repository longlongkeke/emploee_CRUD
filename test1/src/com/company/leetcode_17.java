package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode_17 {
    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        System.out.println(list);
    }
    public static List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        StringBuilder stringBuilder=new StringBuilder();
        HashMap<Character,String> hashMap=new HashMap<>();
        hashMap.put('2',"abc");
        hashMap.put('3',"def");
        hashMap.put('4',"ghi");
        hashMap.put('5',"jkl");
        hashMap.put('6',"mno");
        hashMap.put('7',"pqrs");
        hashMap.put('8',"tuv");
        hashMap.put('9',"wxyz");
        backtracing(res,digits,hashMap,0,stringBuilder);
        return res;

    }
    public static void backtracing(List<String> res,String digits,HashMap<Character,String> hashMap,int ids,StringBuilder stringPath){
        if(stringPath.length()==digits.length()){//到达叶子结点 即字符串的长度等于给的集合长度 说明得到了一个解
            res.add(stringPath.toString());
            return;
        }
        String s = hashMap.get(digits.charAt(ids));
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            stringPath.append(c);
            backtracing(res,digits,hashMap,ids+1,stringPath);//ids+1是指digits字符串里的字符索引加一
            stringPath.deleteCharAt(stringPath.length()-1);
        }
    }
}
