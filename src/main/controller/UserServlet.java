package main.controller;

import main.model.User;
import main.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author rtl
 * @site elbadaernu404.github.io
 * @company suzhou university
 * @create 2020-06-21 16:40
 */
public class UserServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//获取表单中的属性值
        String username=req.getParameter("name");
        String password=req.getParameter("password");
//新建一个user对象
        User user=new User();
        user.setName(username);
        user.setPassword(password);
        //调用service，完成最后的注册功能
        UserService userService=new UserService();
        userService.addUser(user);
//注册完成后，跳转到登录页面
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
