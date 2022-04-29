package main.controller;

import main.service.UserDeleteService;
import net.sf.json.JSONObject;

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
public class UserDelete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDeleteService userDeleteService=new UserDeleteService();
      String id = req.getParameter("id");
        userDeleteService.deleteUserById(Integer.parseInt(id));

        JSONObject result=new JSONObject();
        result.put("success","true");

        resp.getWriter().write(result.toString());
    }
}
