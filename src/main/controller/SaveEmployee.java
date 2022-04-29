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
 * @create 2020-06-23 16:55
 */
public class SaveEmployee extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SaveEmployeeService saveEmployee=new SaveEmployeeService();
        String employeename=req.getParameter("employeename");
        String employeedept=req.getParameter("employeedept");
        String employeeemail=req.getParameter("employeeemail");

        System.out.println(employeename);
        System.out.println(employeedept);
        System.out.println(employeeemail);


        Employee employee=new Employee();
        employee.setEmployeeemail(employeeemail);
        employee.setEmployeedept(employeedept);
        employee.setEmployeename(employeename);
        //保存前台传递过来的用户名和密码
        saveEmployee.saveEmployee(employee);

    }
}
