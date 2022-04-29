package main.service;

import main.dao.LoginDao;
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
public class LoginService implements LoginDao {
    @Override
    public List login(User user) {
        //返回值的类型是一个集合
        List list=new ArrayList();
        PreparedStatement ps=null;
        String sql ="select * from user where name =? and password=?" ;
//jdbc去实现查询功能

        Connection conn = null;
        conn = JdbcUtil.getConn();

        try {
            ps= conn.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());

            ResultSet resultSet =ps.executeQuery();//执行查询语句
//遍历这个结果集
            while(resultSet.next()){
                    String name=resultSet.getString(2);
                    String password=resultSet.getString(3);
                    list.add(name);
                list.add(password);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
