package com.company;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class leetcode_20 {
    public static void main(String[] args) {
        boolean valid = isValid("(){}}{");
        System.out.println(valid);
    }
    public static boolean isValid(String s) {//算法思想：当栈为空时 直接入栈 不为空时 判断栈顶元素和即将进栈的元素是否构成有效的左右括号 如果构成就弹出栈顶元素 继续遍历下一个字符 反之 入栈
        boolean flag=false;
        HashMap<Character,Character> hashMap=new HashMap<>();
        hashMap.put('{','}');
        hashMap.put('(',')');
        hashMap.put('[',']');
        hashMap.put('}','{');
        hashMap.put(')','(');
        hashMap.put(']','[');
        LinkedList<Character> linkedlist=new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(linkedlist.isEmpty()){//栈为空
                linkedlist.push(s.charAt(i));//入栈
            }else{
                if(isduiyng(linkedlist.peek(),s.charAt(i),hashMap)){
                    linkedlist.pop();
                }else{
                    linkedlist.push(s.charAt(i));
                }
            }
        }
        if(linkedlist.size()==0){
            flag=true;
        }

        return flag;
    }
    public static boolean isduiyng(Character ch1,Character ch2,HashMap<Character,Character> hashMap){
        Character character = hashMap.get(ch1);
        Character character1 = hashMap.get(ch2);
//        if(ch2==character&&ch1==character1){这样判断有bug 当出现}{时也会return true
//            return true;
//        }
        if(ch1=='}'||ch1==']'||ch1==')'){
          return  false;
       }
        if(character1==ch1){
            return true;
        }

        return false;
    }
}
