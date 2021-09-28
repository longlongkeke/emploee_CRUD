package cn.itcast.Controller;

import cn.itcast.Service.impl.Deptment;
import cn.itcast.bean.Department;
import cn.itcast.bean.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeptmentController {
    @Autowired
    Deptment deptment;
    @RequestMapping("/getAllDept")
    @ResponseBody
    public Msg getAllDept(){
        List<Department> departments = deptment.getDept();
        return Msg.success().add("depts",departments);

    }
}
