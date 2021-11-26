package com.example.fkapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * //String url = "jdbc:mysql://172.27.0.5:3306/class";//未处理字符串乱码问题
 * //处理字符串乱码以及其他问题
 * // String url = "jdbc:mysql://172.27.0.5:3306/fkapp?useUnicode=true&characterEncoding=UTF-8&&useSSL=False";
 */
public class CommonUtils {

    public static final String connecturl = "jdbc:mysql://192.168.1.112:3306/sys?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    public static final String driver = "com.mysql.cj.jdbc.Driver";
    public static final String usename = "root";
    public static final String password = "123456";

    //1.Mysql数据库驱动加载类
    public static  Connection getConnection() {
                try {
                    Class.forName(driver);
                    Connection con = DriverManager.getConnection(connecturl, usename, password);
                    return con;
                } catch (Exception e) {
                    e.printStackTrace();//抛出异常
                    return null;
                }
    }

    //2.Mysql数据库连接关闭类
    public static void closeConnection(ResultSet rs, Statement stmt,Connection con){
        {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
