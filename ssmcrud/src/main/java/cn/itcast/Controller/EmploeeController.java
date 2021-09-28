package cn.itcast.Controller;

import cn.itcast.Service.impl.Deptment;
import cn.itcast.Service.impl.EmploeeServiceimpl;
import cn.itcast.bean.Department;
import cn.itcast.bean.Emplyee;
import cn.itcast.bean.Msg;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/emplyee")
public class EmploeeController {
    @Autowired
    EmploeeServiceimpl emploeeServiceimpl;
    @Autowired
    Deptment deptment;
    @RequestMapping("/getEmploee")
    @ResponseBody
    public Msg getEmplwithJson(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn, 5);
        List<Emplyee> emplyees = emploeeServiceimpl.getEmploee();
        PageInfo pageInfo=new PageInfo(emplyees,5);
        return Msg.success().add("pageInfo",pageInfo);
    }
    //@RequestMapping("/getEmploee")
    public String getEmploee(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
    //引入pageshelper插件
        PageHelper.startPage(pn, 5);

        /*List<Emplyee> emploee = emploeeServiceimpl.getEmploee();*/
        List<Emplyee> emplyees = emploeeServiceimpl.getEmploee();
        PageInfo pageInfo=new PageInfo(emplyees,5);
        model.addAttribute("pageInfo",pageInfo);
      // List<Emplyee> te = (List<Emplyee>) emploeedao.selectByPrimaryKey(1);

      //  System.out.println(emploeeServiceimpl);
        System.out.println(pageInfo);
        return "list";
    }
    @RequestMapping(value = "/saveEmp",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(Emplyee emplyee){
//        System.out.println("emp:"+emplyee);
        emploeeServiceimpl.saveemp(emplyee);
        return Msg.success();

    }
    //回显员工数据
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Msg emp(@PathVariable("id")Integer id){
//        System.out.println("emp:"+emplyee);
        System.out.println("77777777777777777");
       Emplyee emplyee= emploeeServiceimpl.getEmpById(id);
        System.out.println("从数据库得到的员工信息："+emplyee);
        return Msg.success().add("emp",emplyee);

    }
    @RequestMapping(value = "/editEmp/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Msg editEmp(Emplyee emplyee){
        System.out.println("edit:"+emplyee);
//        System.out.println("emp:"+emplyee);
        emploeeServiceimpl.updatEmp(emplyee);
        return Msg.success();

    }
}
