package main.service;

import main.dao.SaveUserDao;
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
public class SaveUserService implements SaveUserDao{
    @Override
    public void saveUser(User user) {
        PreparedStatement ps=null;
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

    @Override
    public void updateUser(User user) {
        PreparedStatement ps=null;
        //真正的把用户注册的数据进行操作到数据库中
        String sql="update user set NAME =? ,password=? where id=?";
        //？是占位符的意思
        Connection conn = null;
        conn = JdbcUtil.getConn();

        try {
            ps= conn.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            ps.setInt(3,user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
