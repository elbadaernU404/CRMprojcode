package main.service;

import main.dao.employeeDeleteDao;

import main.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author rtl
 * @site elbadaernu404.github.io
 * @company suzhou university
 * @create 2020-06-23 16:44
 */
public class EmployeeDeleteService implements employeeDeleteDao {
    @Override
    public String deleteEmployeeById(int id) {
        PreparedStatement ps=null;
        //真正的把用户注册的数据进行操作到数据库中
        String sql="DELETE  FROM employee where id=?";
        //？是占位符的意思
        Connection conn = null;
        conn = JdbcUtil.getConn();
        try {
            ps= conn.prepareStatement(sql);
            ps.setInt(1,id);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "success";
    }
}