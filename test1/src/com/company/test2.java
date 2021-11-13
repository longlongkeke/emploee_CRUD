package com.company;
import java.util.Scanner;
public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        if (s.length() < 2) {
            System.out.println(0);
            return;
        }
        int i = 0;
        int j = s.length() - 1;
        int res = 0;
        while (i < j) {
            res += Math.abs(s.charAt(i) - s.charAt(j));
            i++;
            j--;
        }
        System.out.println(res);
    }
}
