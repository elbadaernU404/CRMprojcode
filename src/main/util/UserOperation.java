package main.util;

import main.model.User;

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
public class UserOperation {
    public List selectPage(int offset, int size) {//注意返回值null和list.size()==0的区别
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<User> list=new ArrayList<User>();//返回值
        Connection conn = null;
        conn = JdbcUtil.getConn();
        try {
            ps=conn.prepareStatement("select * from  user  limit "+offset+","+size);
            rs=   ps.executeQuery();
            while(rs.next()){
                User one=new User();//返回值中的一个
                one.setId(rs.getInt(1));
                one.setName(rs.getString(2));
                one.setPassword(rs.getString(3));
                list.add(one);//添加到列表
            }
            return list;
        } catch (Exception ex) {

            return null;
        }
    }

//计算user类在数据库中总共有多少条数据
    public  int selectCount(){
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<User> list=new ArrayList<User>();//返回值
        Connection conn = null;
        conn = JdbcUtil.getConn();
        int count=0;
        try {
            ps=conn.prepareStatement("select count(*) from  user ");
            rs=   ps.executeQuery();

            while(rs.next())
            {
//打印的就是总记录数。把检索结果看成只有一跳记录一个字段的表
                count=rs.getInt(1);
                System.out.println(count);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

return count;
    }

}
