package main.service;

import main.dao.SaveEmployeeDao;
import main.model.Employee;
import main.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author rtl
 * @site elbadaernu404.github.io
 * @company suzhou university
 * @create 2020-06-21 16:40
 */
public class SaveEmployeeService implements SaveEmployeeDao {
    @Override
    public void saveEmployee(Employee employee) {
        PreparedStatement ps=null;
        //真正的把用户注册的数据进行操作到数据库中
        String sql="INSERT into employee(employeename,employeedept,employeeemail) values(?,?,?)";
        //？是占位符的意思
        Connection conn = null;
        conn = JdbcUtil.getConn();

        try {
            ps= conn.prepareStatement(sql);
            ps.setString(1,employee.getEmployeename());
            ps.setString(2,employee.getEmployeedept());
            ps.setString(3,employee.getEmployeeemail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        PreparedStatement ps=null;

        String sql="update employee set employeename =? ,employeedept=? ,employeeemail=? where id=?";

        Connection conn = null;
        conn = JdbcUtil.getConn();

        try {
            ps= conn.prepareStatement(sql);
            ps.setString(1,employee.getEmployeename());
            ps.setString(2,employee.getEmployeedept());
            ps.setString(3,employee.getEmployeeemail());
            ps.setInt(4,employee.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
