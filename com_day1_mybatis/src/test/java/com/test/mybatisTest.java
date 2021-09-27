package com.test;

import com.dao.IUserdao;
import com.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class mybatisTest {
    InputStream in;
    SqlSession sqlSession;
    IUserdao userdao;

    @Before
    public void init() {
        //读取配置文件
        try {
            in = Resources.getResourceAsStream("sqlconfig.xml");
            System.out.println(in);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            System.out.println(builder);
            SqlSessionFactory factory = builder.build(in);
            System.out.println(factory);
            sqlSession = factory.openSession();
            //使用sqlsession创建dao接口代理对象
            userdao = sqlSession.getMapper(IUserdao.class);
            //使用代理执行方法


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void end() throws IOException {
        sqlSession.close();
        in.close();
    }

    @Test
    public void finall() throws IOException {

        List<User> users = userdao.findall();
        for (User user : users) {
            System.out.println(user);

        }

    }
    @Test
    public void insert() {
        User user = new User();
        user.setUsername("新增");
        user.setPassword("新增");
        user.setAge(3);
        userdao.insert(user);
        sqlSession.commit();
    }
    @Test
    public void delete() {
        userdao.delete(3);
        sqlSession.commit();
    }
    @Test
    public void update() {
        User user = new User();
        user.setId(1);
        user.setUsername("新增");
        user.setPassword("新增");
        user.setAge(3);
        userdao.update(user);
        sqlSession.commit();
    }

    }

