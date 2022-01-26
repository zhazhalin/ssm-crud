package com.atguigu.crud.test;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.DepartmentMapper;
import com.atguigu.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author zhazhalin
 * @version 1.0
 * @date 2022/1/25 14:19
 */
//推荐使用Spring的单元测试，可以自动注入我们所需要的组件
    /*1、先导入Spring-test的依赖
    2、使用ContextConfiguration指定Spring文件的位置
    3、接下来想用哪些组件，直接autowird就行了
    */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    SqlSession sqlSession;
    @Test
    public void testCRUD() {
        /*departmentMapper.insertSelective(new Department(null,"开发部"));
        departmentMapper.insertSelective(new Department(null,"开发部"));*/
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for(int i=0;i<1000;i++){
            String s = UUID.randomUUID().toString().substring(0, 5) + i;
            mapper.insertSelective(new Employee(null,s,"M",s+"@guigu.com",1));
        }
    }

}
