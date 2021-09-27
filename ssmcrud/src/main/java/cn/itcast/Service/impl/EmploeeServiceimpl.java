package cn.itcast.Service.impl;

import cn.itcast.Dao.DepartmentMapper;
import cn.itcast.Dao.EmplyeeMapper;
import cn.itcast.Service.IEmploeeService;
import cn.itcast.bean.Department;
import cn.itcast.bean.DepartmentExample;
import cn.itcast.bean.Emplyee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploeeServiceimpl {
    @Autowired
    EmplyeeMapper emploeedao;
    @Autowired
    DepartmentMapper departmentMapper;
    public List<Emplyee> getEmploee() {
        return emploeedao.selectByExampleWithDept(null);
    }
}
