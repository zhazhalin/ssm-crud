package com.atguigu.crud.controller;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zhazhalin
 * @version 1.0
 * @date 2022/1/25 16:24
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        //引入分页插件
        //在查询之前只需要调用,每页5条数据
        PageHelper.startPage(pn, 5);
        List<Employee> employees = employeeService.getEmps();
        //使用pageInfo来包装我们的信息,只需要将这个交给页面就行了
        //封装了详细的信息，包括我们查询出来的所有数据，传入连续显示的页数
        PageInfo pageInfo=new PageInfo(employees);
        model.addAttribute("pageInfo",pageInfo);
        return "list";
    }
}
