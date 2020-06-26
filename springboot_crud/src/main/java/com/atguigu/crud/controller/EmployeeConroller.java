package com.atguigu.crud.controller;

import com.atguigu.crud.dao.DepartmentDao;
import com.atguigu.crud.dao.EmployeeDao;
import com.atguigu.crud.entities.Department;
import com.atguigu.crud.entities.Employee;
import com.fasterxml.jackson.databind.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.security.pkcs11.Secmod;

import java.util.Collection;

/**
 * @author XuMingyue
 * @create 2020-04-13 15:50
 */
@Controller
public class EmployeeConroller {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    /**
     * 查询所有员工信息
     */
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    /**
     * 进入添加员工页面
     */
    @GetMapping("/emp")
    public String addEmpPage(Model  model){
        //查出所有部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    /**
     * 添加员工
     * springMvc自动将请求参数和入参对象的属性进行一一绑定，要求：请求参数的名字和javaBean参数中的属性名一样
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return  "redirect:/emps" ;
    }

    /**
     * 跳转修改页面
     */
       @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        //获取查询的值
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        //显示所有部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    /**
     * 员工修改
     */
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        //跳转到查询员工页面
        return "redirect:/emps";
    }

    /**
     * 删除员工
     */
    @RequestMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
