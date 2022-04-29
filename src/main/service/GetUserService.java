package main.service;

import main.dao.GetUserDao;
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
 * @create 2020-06-21 16:40
 */
public class GetUserService implements GetUserDao {
    @Override
    public List<User> GetAllUser() {
        List<User> list=new ArrayList();
        PreparedStatement ps=null;
        String sql ="select * from user " ;
//jdbc去实现查询功能

        Connection conn = null;
        conn = JdbcUtil.getConn();

        try {
            ps= conn.prepareStatement(sql);

            ResultSet resultSet =ps.executeQuery();//执行查询语句
//遍历这个结果集
            while(resultSet.next()){
                int id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                String password=resultSet.getString(3);

                User user=new User(id,name,password);

                list.add(user);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
