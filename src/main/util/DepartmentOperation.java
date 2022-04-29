package main.util;

import main.model.Department;

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
 * @create 2020-06-21 16:54
 */
public class DepartmentOperation {
    public List selectPage(int offset, int size) {//注意返回值null和list.size()==0的区别
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Department> list=new ArrayList<Department>();//返回值
        Connection conn = null;
        conn = JdbcUtil.getConn();
        try {
            ps=conn.prepareStatement("select * from  department  limit "+offset+","+size);
            rs=   ps.executeQuery();
            while(rs.next()){
                Department one=new Department();//返回值中的一个
                one.setNumber(rs.getInt(1));
                one.setDepartmentname(rs.getString(2));
                one.setDepartmentfunction(rs.getString(3));
                list.add(one);//添加到列表
            }
            return list;
        } catch (Exception ex) {

            return null;
        }
    }

    //计算Department类在数据库中总共有多少条数据
    public  int selectCount(){
        PreparedStatement ps=null;
        ResultSet rs=null;
        ArrayList<Department> list=new ArrayList<Department>();//返回值
        Connection conn = null;
        conn = JdbcUtil.getConn();
        int count=0;
        try {
            ps=conn.prepareStatement("select count(*) from  department ");
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