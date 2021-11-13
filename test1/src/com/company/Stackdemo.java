package com.company;

import java.util.*;


public class Stackdemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        List<String> list = tolist(str);
        System.out.println(list);
      Stack<String> str1 = tolast(list);
      List<String> list1= Arrays.asList(new String[str1.size()]);
      int item=str1.size()-1;
        while (str1.size() != 0&&item>=0) {
            list1.set(item,str1.pop());
            item--;
//            System.out.println(str1.pop());
        }
        System.out.println(list1);
        String result =cal(list1);
        System.out.println(result);


    }

    private static String cal(List<String> list1) {
        Stack<String> st=new Stack<>();
        for(int i=0;i<list1.size();i++){
            if(list1.get(i).matches("\\d+")){
                st.push(list1.get(i));
            }else{
                int one=Integer.parseInt(st.pop());
                int two=Integer.parseInt(st.pop());
                st.push(calcul(two,one,list1.get(i)));

            }

        }
        String s=st.pop();
        return  s;
    }
    private  static String calcul(int op1, int op2, String ch){
        switch (ch){
            case "+":
                return (op1+op2)+"";
            case "-":
                return (op1-op2)+"";
            case "*":
                return (op1*op2)+"";
            case "/":
                return (op1/op2)+"";

        }


        return ch;
    }

    private static List<String> tolist(String str) {
        str = str.replaceAll("(?<![0-9)}\\]])(?=-[0-9({\\[])", "0");

        str = str.replaceAll("\\[", "(");
        str = str.replaceAll("\\]", ")");
        str = str.replaceAll("\\{", "(");
        str = str.replaceAll("\\}", ")");

        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length();) {
            if (Character.isDigit(str.charAt(i))) {
                String str1 = "";
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    str1 += str.charAt(i);;
                    i++;
                }
                list.add(str1);
            } else {
                list.add(str.charAt(i) + "");
                i++;
            }
        }

        return list;
    }

    public  static Stack<String> tolast(List<String> list) {
        Stack<String> st = new Stack<>();//结果栈
        Stack<String> st1 = new Stack<>();//符号栈
        for (int i = 0; i < list.size(); i++) {
            String item=list.get(i);
            System.out.println(item.equals("("));
            if (item.matches("\\d+")) {
                st.push(item);
            } else if (item.equals("(")){
                st1.push(item);
            } else if (item.equals(")")) {
                while (!st1.peek().equals("(")) {
                    st.push(st1.pop());
                }
                st1.pop();
            } else {
                while (st1.size()!=0&&getval(item) <= getval(st1.peek())) {
                    st.push(st1.pop());
                }
                st1.push(item);
            }

        }
        while (st1.size() != 0) {
            st.push(st1.pop());//将符号栈依次弹出到结果栈
        }

        return st;
    }

    private static int getval(String s) {
        int i = 0;
        switch (s) {
            case "+":
                i = 1;
                break;
            case "-":
                i = 1;
                break;
            case "*":
                i = 2;
                break;
            case "/":
                i = 2;
                break;
        }
        return  i;
    }


}
