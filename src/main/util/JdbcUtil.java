package main.util;

import java.sql.*;

public class JdbcUtil {
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private JdbcUtil() {}

    public static Connection getConn(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmpro?useUnicode=true&characterEncoding=utf-8", "root","root");//连接数据库
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConn(Connection conn){
        try {
            if(conn != null ){
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static PreparedStatement getPStmt(Connection conn,String sql){
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    public static void closeStmt(Statement stmt){
        try {
            if(stmt != null ){
                stmt.close();
                stmt = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ResultSet executeQuery(Statement stmt,String sql){
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void closeRs(ResultSet rs){
        try {
            if(rs != null ){
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(Connection conn,String sql){//重载
        ResultSet rs = null;
        try {
            rs = conn.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}