package com.company;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Testtolast {
    @Test
    public  void tets(){
        Stackdemo s=new Stackdemo();
        List<String> li=new ArrayList<String>(Arrays.asList("1","+","(","(","2553","+","3",")","×","4",")","-","5"));
        Stack<String> stack = s.tolast(li);
    }

}
