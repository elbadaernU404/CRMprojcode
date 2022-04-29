package main.service;

import main.dao.UserDao;
import main.model.User;
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
public class UserService implements UserDao {
    PreparedStatement ps=null;
    @Override
    public void addUser(User user) {
        //真正的把用户注册的数据进行操作到数据库中
        String sql="INSERT into user(name,password) values(?,?)";
        //？是占位符的意思
        Connection conn = null;
            conn = JdbcUtil.getConn();

        try {
            ps= conn.prepareStatement(sql);
           ps.setString(1,user.getName());
           ps.setString(2,user.getPassword());
           ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
