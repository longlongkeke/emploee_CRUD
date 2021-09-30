package cn.itcast.Service.impl;

import cn.itcast.Dao.DepartmentMapper;
import cn.itcast.Dao.EmplyeeMapper;
import cn.itcast.Service.IEmploeeService;
import cn.itcast.bean.Department;
import cn.itcast.bean.DepartmentExample;
import cn.itcast.bean.Emplyee;
import cn.itcast.bean.EmplyeeExample;
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

    public void delEmpByid(Integer id) {
        emploeedao.deleteByPrimaryKey(id);
    }

    public void delEmp(List<Integer> list) {
        System.out.println("service层："+list);
        EmplyeeExample emplyeeExample=new EmplyeeExample();
        EmplyeeExample.Criteria criteria=emplyeeExample.createCriteria();
        //delete from xxx where emp_id in(1,2,3)
        criteria.andIdIn(list);

        emploeedao.deleteByExample(emplyeeExample);
    }

    public List<Emplyee> selectExampleEmp(String empName) {
        System.out.println("模糊查询的service:"+empName);
        EmplyeeExample emplyeeExample1=new EmplyeeExample();
        EmplyeeExample.Criteria criteria=emplyeeExample1.createCriteria();
        //delete from xxx where emp_id in(1,2,3)
        criteria.andEmpnameLike("%"+empName+"%");
        return emploeedao.selectByExampleWithDept(emplyeeExample1);

    }
}
