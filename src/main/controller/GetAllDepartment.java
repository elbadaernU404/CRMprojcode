package main.controller;

import main.model.Department;
import main.service.GetDepartmentService;
import main.util.DepartmentOperation;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAllDepartment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        PrintWriter out = response.getWriter();
        //请求页码、每页显示行数、偏移、总数
        int page,rows,offset,total;
        //获取
        String input_page=request.getParameter("page");
        page=(input_page==null)?1:Integer.parseInt(input_page);//页码数
        String input_rows=request.getParameter("rows");
        rows=(input_rows==null)?10:Integer.parseInt(input_rows);//每页多少条数据
        offset=(page-1)*rows;
        DepartmentOperation operation=new DepartmentOperation();
        total=operation.selectCount();
        List<Department> departments=operation.selectPage(offset, rows);
        Map<String, Object> jsonMap = new HashMap<String, Object>();//定义map
        jsonMap.put("total", total);//total键 存放总记录数，必须的
        jsonMap.put("rows", departments);//rows键 存放每页记录 list
        String result = JSONObject.fromObject(jsonMap).toString();//格式化result   一定要是JSONObject
        out.print(result);
        out.flush();
        out.close();



    }}

