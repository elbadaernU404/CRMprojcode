package main.controller;

import main.model.User;
import main.service.SaveUserService;

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
public class UserSave extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String id=  req.getParameter("id");
        String name=  req.getParameter("name");
        String password=  req.getParameter("password");
//UPDATE user SET `name`="wangwu" , `password`="admin" where id=5
        System.out.println(id);
        System.out.println(name);
        System.out.println(password);
        User user=new User(Integer.parseInt(id),name,password);
        //字符串
        SaveUserService saveUserService=new SaveUserService();

        saveUserService.updateUser(user);

    }
}
