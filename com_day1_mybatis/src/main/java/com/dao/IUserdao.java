package com.dao;

import com.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IUserdao {
    @Select("select * from user")
    List<User> findall();
    @Insert("insert into user(username,password,age)values(#{username},#{password},#{age})")
    void insert(User user);
    @Delete("delete from user where id=#{id}")
    void delete(Integer id);
    @Update("update  user set username=#{username},password=#{password}where id=#{id}")
    void update(User user);
}
