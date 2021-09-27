package cn.itcast.Controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
//@RequestMapping("/emplyee")
public class EmploeeController {
    @Autowired
    EmploeeServiceimpl emploeeServiceimpl;
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
}
