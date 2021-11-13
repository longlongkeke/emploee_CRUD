package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class offer_033 {
    public static void main(String[] args) {
        String[] arr=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(arr);

        System.out.println(lists);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
//        int left=0,end=0;
//        while (left)
        HashMap<String,List<String>> map=new HashMap<>();
       List<List<String>> res=new ArrayList<>();
       List<String> p=new ArrayList<>();
        if(strs.length==1){
            p.add(strs[0]);
            res.add(new ArrayList<>(p));
            return res;
        }
        for(int i=0;i<strs.length;i++){
           char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
                    List<String> orDefault = map.getOrDefault(key, new ArrayList<String>());
                    orDefault.add(strs[i]);
                    map.put(key,orDefault);
       }

        return new ArrayList<List<String>>(map.values());

    }

}
