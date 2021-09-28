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
    public void saveemp(Emplyee emplyee){
        System.out.println("111111111");
        emploeedao.insertSelective(emplyee);
    }

    public Emplyee getEmpById(Integer id) {
        Emplyee emplyee = emploeedao.selectByPrimaryKey(id);
        return emplyee;
    }

    public void updatEmp(Emplyee emplyee) {
        emploeedao.updateByPrimaryKeySelective(emplyee);
    }
}
