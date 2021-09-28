package cn.itcast.Service.impl;

import cn.itcast.Dao.DepartmentMapper;
import cn.itcast.bean.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Deptment {
    @Autowired
    DepartmentMapper departmentMapper;
    public List<Department> getDept(){
        List<Department> departments = departmentMapper.selectByExample(null);
        System.out.println(departmentMapper);
        return departments;
    }
}
