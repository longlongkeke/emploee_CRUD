package com.company;

import java.util.ArrayList;

public class offer_027 {

    public static void main(String[] args) {

        ArrayList<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        System.out.println(list);
        int i=0;
        String str="";
        while(i<list.size()){//将列表转为字符串
            str+=list.get(i);
            i++;
        }

    }

}
