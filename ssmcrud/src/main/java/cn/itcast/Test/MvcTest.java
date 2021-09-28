package cn.itcast.Test;

import cn.itcast.bean.Emplyee;
import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicantionContext.xml","classpath:springmvc.xml"})
public class MvcTest {
//    虚拟mvc请求 获取到请求结果
    MockMvc mockMvc;
    @Autowired
    WebApplicationContext context;
    @Before
    public void initmockmvc(){
        mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void testPage() throws Exception {

            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/getEmploee").param("pn", "5")).andReturn();
            MockHttpServletRequest request = result.getRequest();
            PageInfo pageInfo   = (PageInfo) request.getAttribute("pageInfo");
             List<Emplyee> list = pageInfo.getList();
        for (Emplyee item:list) {
           // System.out.println(item);
            System.out.println("ID:"+item.getId()+"name:"+item.getEmpname()+"gender:"+item.getGender());
        }
        System.out.println("当前页码："+pageInfo.getPageNum());
            System.out.println("总共页码："+pageInfo.getPages());

    }

}
