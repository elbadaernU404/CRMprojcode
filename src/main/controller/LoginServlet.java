package main.controller;

import main.model.User;
import main.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author rtl
 * @site elbadaernu404.github.io
 * @company suzhou university
 * @create 2020-06-21 16:40
 */

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //从登陆界面获得了用户名和密码
            String username = request.getParameter("name");
            String password = request.getParameter("password");
            //与数据库的数据进行对比
        LoginService loginService=new LoginService();
        User user=new User();
        user.setName(username);
        user.setPassword(password);
       List list= loginService.login(user);

        if (list.size()>0){
            //用户名密码存在，登陆成功
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else{
            //用户名密码不存在，登陆失败
            request.getRequestDispatcher("register.jsp").forward(request,response);

        }



    }
}
