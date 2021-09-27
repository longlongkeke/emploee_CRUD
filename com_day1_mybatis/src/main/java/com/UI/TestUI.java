package com.UI;

import com.dao.Accountdao;
import com.service.Accountservice;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUI {
         @Test
        public void test(){
            ApplicationContext ac= new ClassPathXmlApplicationContext("beans.xml");
            Accountservice ser= (Accountservice) ac.getBean("accountservice");
            Accountdao dao=ac.getBean("accountdao", Accountdao.class);
            ser.saveaccount();
            System.out.println(ser);
            System.out.println(dao);
        }



}
