package main.controller;

import main.model.Employee;
import main.service.SaveEmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author rtl
 * @site elbadaernu404.github.io
 * @company suzhou university
 * @create 2020-06-23 17:14
 */
public class EmployeeSave extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=  req.getParameter("id");
        String employeename=  req.getParameter("employeename");
        String employeedept=  req.getParameter("employeedept");
        String employeeemail=  req.getParameter("employeeemail");
        
        System.out.println(id);
        System.out.println(employeename);
        System.out.println(employeedept);
        System.out.println(employeeemail);
        Employee employee=new Employee(Integer.parseInt(id),employeename,employeedept,employeeemail);
        //字符串
        SaveEmployeeService saveEmployeeService=new SaveEmployeeService();

        saveEmployeeService.updateEmployee(employee);

    }
}
