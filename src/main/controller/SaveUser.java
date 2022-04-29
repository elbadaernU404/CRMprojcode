package main.controller;

import main.model.User;
import main.service.SaveUserService;

import javax.net.ssl.HttpsURLConnection;
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
public class SaveUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           SaveUserService saveUser=new SaveUserService();
       String name=req.getParameter("name");
       String password=req.getParameter("password");

       System.out.println(name);
        System.out.println(password);


            User user=new User();
            user.setPassword(password);
            user.setName(name);
            //保存前台传递过来的用户名和密码
           saveUser.saveUser(user);

    }
}
