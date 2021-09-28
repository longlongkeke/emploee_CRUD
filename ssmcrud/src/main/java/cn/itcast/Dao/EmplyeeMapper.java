package cn.itcast.Dao;

import cn.itcast.bean.Emplyee;
import cn.itcast.bean.EmplyeeExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EmplyeeMapper {
    int countByExample(EmplyeeExample example);

    int deleteByExample(EmplyeeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Emplyee record);

    int insertSelective(Emplyee record);

    List<Emplyee> selectByExample(EmplyeeExample example);

    Emplyee selectByPrimaryKey(Integer id);

    List<Emplyee> selectByExampleWithDept(EmplyeeExample example);

    Emplyee selectByPrimaryKeyWithDept(Integer id);

    int updateByExampleSelective(@Param("record") Emplyee record, @Param("example") EmplyeeExample example);

    int updateByExample(@Param("record") Emplyee record, @Param("example") EmplyeeExample example);

    int updateByPrimaryKeySelective(Emplyee record);

    int updateByPrimaryKey(Emplyee record);

}