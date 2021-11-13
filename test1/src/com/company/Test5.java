package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n = input.nextInt();
        String str=n+"";
        String str1="";
        LinkedHashSet<String> set=new LinkedHashSet<>();
        for (int i=str.length();i>0;i--){
            set.add(str.substring(i-1,i));
        }

        for (String item:set) {
            str1+=item;
        }
        int i = Integer.parseInt(str1);
        System.out.println(i);

    }
}
