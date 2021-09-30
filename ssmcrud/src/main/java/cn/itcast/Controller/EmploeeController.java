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
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.SessionScope;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
        System.out.println("查询得到的全部员工："+emplyees);
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
    @RequestMapping(value = "/delEmp/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg delEmp(@PathVariable("id")String id){
        if(id.contains("-")){
        //多个删除
         List<Integer> list=new ArrayList<>();
         String[] ids= id.split("-");
            System.out.println(ids);
        for (String item:ids) {
            list.add(Integer.parseInt(item));
        }
            System.out.println(list);
            emploeeServiceimpl.delEmp(list);

        }else{//单个删除
            int empid = Integer.parseInt(id);
            emploeeServiceimpl.delEmpByid(empid);
        }

        return Msg.success();

    }
    @RequestMapping(value = "/selectExampleEmp/{empName}",method = RequestMethod.GET)
    @ResponseBody
    public Msg selectExampleEmp(@RequestParam(value = "pn",defaultValue = "1")Integer pn, @PathVariable("empName")String empName, HttpSession session){
        System.out.println("模糊查询的controller:"+empName);
        PageHelper.startPage(pn, 5);
        List<Emplyee> emplyees = emploeeServiceimpl.selectExampleEmp(empName);
        System.out.println("模糊查询的结果："+emplyees);
      // request.setAttribute("emplyees",emplyees);
        PageInfo pageInfo=new PageInfo(emplyees,5);
        System.out.println(pageInfo);
        session.setAttribute("name",empName);
        return Msg.success().add("pageInfo",pageInfo);

    }
    @RequestMapping(value = "/selectExampleEmpByid",method = RequestMethod.GET)
    @ResponseBody
    public Msg selectExampleEmpByid(@RequestParam(value = "pn")Integer pn,HttpSession session){// 遇到的问题：模糊查询之后分页条不能正确查询
                                            //  解决方案：controller里写两个方法 分别接收id 和模糊查询条件。通过session把模糊查询的条件存上
        System.out.println("模糊查询的controller的pn:"+pn);
        PageHelper.startPage(pn, 5);
        System.out.println("pn:"+pn);
//        List<Emplyee> emplyees = (List<Emplyee>) request.getAttribute("emplyees");
    String emplyees = (String) session.getAttribute("name");
        List<Emplyee> emplyeess = emploeeServiceimpl.selectExampleEmp(emplyees);
        System.out.println(emplyees);
        PageInfo pageInfo=new PageInfo(emplyeess,5);
        return Msg.success().add("pageInfo",pageInfo);

    }


}
