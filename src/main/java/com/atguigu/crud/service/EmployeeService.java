package com.atguigu.crud.service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhazhalin
 * @version 1.0
 * @date 2022/1/25 16:29
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    public List<Employee> getEmps(){
        List<Employee> employees = employeeMapper.selectByExampleWithDept(null);
        return employees;
    }
}
