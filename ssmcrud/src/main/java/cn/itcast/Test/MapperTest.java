package cn.itcast.Test;

import cn.itcast.Dao.DepartmentMapper;
import cn.itcast.Dao.EmplyeeMapper;
import cn.itcast.bean.Department;
import cn.itcast.bean.Emplyee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicantionContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmplyeeMapper emplyeeMapper;
//    @Autowired
//    SqlSessionTemplate sqlSessionTemplate;
    @Test
    public void test(){
        System.out.println(departmentMapper);
//        departmentMapper.insertSelective(new Department(null,"开发部"));
 //    departmentMapper.insertSelective(new Department(null,"员工部"));
//        //EmplyeeMapper mapper = sqlSessionTemplate.getMapper(EmplyeeMapper.class);
//        for (int i=0;i<1000;i++){
//            String uuid = UUID.randomUUID().toString().substring(0, 5)+i;
//            mapper.insertSelective(new Emplyee(null,uuid,"M",uuid+"@qq.com",1));
//        }
     //   emplyeeMapper.insertSelective(new Emplyee(null,"张三","W","1205547998@qq.com",2));

            Emplyee emplyee = emplyeeMapper.selectByPrimaryKey(1);
        System.out.println(emplyee);


    }
}
