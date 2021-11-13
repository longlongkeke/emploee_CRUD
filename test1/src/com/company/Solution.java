package com.company;
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> lll = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        lll.add(list);
        huiSu(S,list,0, lll);
        return lll;
    }

    public void huiSu(int[] S, ArrayList<Integer> ll, int i, ArrayList<ArrayList<Integer>> lll){
        for(; i < S.length; i++){
            ArrayList<Integer> list = new ArrayList<>(ll);
            list.add(S[i]);
            lll.add(list);
            huiSu(S, list, i+1, lll);
        }
    }
}