package main.service;

import main.dao.EmployeeSearchDao;
import main.dao.GetUserDao;
import main.model.Employee;
import main.model.User;
import main.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rtl
 * @site elbadaernu404.github.io
 * @company suzhou university
 * @create 2020-06-23 20:21
 */
public class EmployeeSearchService implements EmployeeSearchDao {
    @Override
    public List<Employee> EmployeeSearch() {
        List<Employee> list=new ArrayList();
        PreparedStatement ps=null;
        String sql ="select * from employee where employeename='?'" ;
//jdbc去实现查询功能

        Connection conn = null;
        conn = JdbcUtil.getConn();

        try {
            ps= conn.prepareStatement(sql);

            ResultSet resultSet =ps.executeQuery();//执行查询语句
//遍历这个结果集
            while(resultSet.next()){
                int id=resultSet.getInt(1);
                String employeename=resultSet.getString(2);
                String employeedept=resultSet.getString(3);
                String employeeemail=resultSet.getString(4);

                Employee employee=new Employee(id,employeename,employeedept,employeeemail);

                list.add(employee);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
