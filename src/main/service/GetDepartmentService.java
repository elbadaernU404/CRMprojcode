package main.service;

import main.dao.GetDepartmentDao;
import main.model.Department;
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
 * @create 2020-06-21 16:40
 */
public class GetDepartmentService implements GetDepartmentDao {
    @Override
    public List<Department> GetAllDepartment() {
        List<Department> list=new ArrayList();
        PreparedStatement ps=null;
        String sql ="select * from department " ;
//jdbc去实现查询功能

        Connection conn = null;
        conn = JdbcUtil.getConn();

        try {
            ps= conn.prepareStatement(sql);

            ResultSet resultSet =ps.executeQuery();//执行查询语句
//遍历这个结果集
            while(resultSet.next()){
                int number=resultSet.getInt(1);
                String departmentname=resultSet.getString(2);
                String departmentfunction=resultSet.getString(3);

                Department department=new Department(number,departmentname,departmentfunction);

                list.add(department);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}

