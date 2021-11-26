package com.example.fkapp;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAL {

    //插入操作
    public static boolean insert(int sid, String sname, String spwd) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = CommonUtils.getConnection(); //1.连接数据库
            String sql = "insert into stuinfo(sid,sname,spwd) values(?,?,?)";
            assert con != null;
            stmt = con.prepareStatement(sql); //2.准备SQL语句（操作前准备）
            //设置stmt中的参数（sql注入）
//            stmt.setInt(1,id);
            stmt.setInt(1, sid);
            stmt.setString(2, sname);
            stmt.setString(3, spwd);
            int result = stmt.executeUpdate(); //3.执行SQL语句发送到数据库插入数据
            if (result > 0) {
                Log.d("MysqlTest", "添加成功");
                return true;
            } else {
                Log.d("MysqlTest", "添加失败");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();//抛出异常
        } finally {
            CommonUtils.closeConnection(rs, stmt, con);//4.关闭数据库
        }
        return false;
    }

    //修改（更新）操作
    public static boolean update(int id, String sname) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = CommonUtils.getConnection(); //1.连接数据库
            String sql = "update stuinfo set sname = ? where id = ?";
            stmt = con.prepareStatement(sql); //2.准备SQL语句（操作前准备）
            //设置stmt中的参数（sql注入）
            stmt.setString(1, sname);
            stmt.setInt(2, id);
            int result = stmt.executeUpdate(); //3.执行SQL语句发送到数据库修改数据
            if (result > 0) {
                Log.d("MysqlTest", "修改成功");
                return true;
            } else {
                Log.d("MysqlTest", "修改失败");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();//抛出异常
        } finally {
            CommonUtils.closeConnection(rs, stmt, con);//4.关闭数据库
        }
        return false;
    }

    //删除操作
    public static boolean delete(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = CommonUtils.getConnection(); //1.连接数据库
            String sql = "delete from stuinfo where id = ?";
            stmt = con.prepareStatement(sql); //2.准备SQL语句（操作前准备）
            //设置stmt中的参数（sql注入）
            stmt.setInt(1, id);
            int result = stmt.executeUpdate(); //3.执行SQL语句发送到数据库删除数据
            if (result > 0) {
                Log.d("MysqlTest", "删除成功");
                return true;
            } else {
                Log.d("MysqlTest", "删除失败");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();//抛出异常
        } finally {
            CommonUtils.closeConnection(rs, stmt, con);//4.关闭数据库
        }
        return false;
    }

    //通过id查询操作
    public static boolean selectid(int id) {
        //注意：加载驱动只能在子线程中进行（重点）
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = CommonUtils.getConnection();//1.连接数据库
            String sql = "select * from stuinfo where id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql); //2.准备SQL语句（操作前准备）
            //设置pstmt中的参数（sql注入）
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery(); //3.执行SQL语句发送到数据库查询数据
            if (rs.next()) {
                String s = rs.getInt(1) + "," + rs.getInt(2) + "," + rs.getString(3) + "," + rs.getString(4);
                Log.d("MysqlTest", s);
                return true;
            } else {
                Log.d("MysqlTest", "查询失败");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace(); //抛出异常
        } finally {
            CommonUtils.closeConnection(rs, stmt, con);//4.关闭数据库
        }
        return false;
    }

    //通过id查询操作显示在textview上
    public static List<StudentModel> SelectById(int id) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = CommonUtils.getConnection();//连接数据库
            stmt = con.createStatement(); //创建Statement
            String sql = "select * from stuinfo where id ='" + id + "'";
            rs = stmt.executeQuery(sql);
            if (rs == null) {
                return null;
            } else {
                List<StudentModel> students = new ArrayList<>(); //用数组遍历字段
                if (rs.next() == false) {
                    return null;
                }
                do {
                    StudentModel student = new StudentModel();
                    student.setId(rs.getInt("id"));
                    student.setId(rs.getInt("sid"));
                    student.setSname(rs.getString("sname"));
                    student.setSpwd(rs.getString("spwd"));
                    students.add(student);
                } while (rs.next());
                return students;
            }
        } catch (SQLException e) {
            e.printStackTrace(); //抛出异常
        } finally {
            CommonUtils.closeConnection(rs, stmt, con);//4.关闭数据库
        }
        return null;
    }

    //通过sname，spwd查询操作
    public static boolean selectByStudent(String sname, String spwd) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = CommonUtils.getConnection(); //1.连接数据库
            String sql = "select * from stuinfo where sname = ? and spwd = ?";
           PreparedStatement pstmt = con.prepareStatement(sql); //2.准备SQL语句（操作前准备）
            //设置stmt中的参数（sql注入）
            pstmt.setString(1, sname);
            pstmt.setString(2, spwd);
            rs = pstmt.executeQuery(); ////3.执行SQL一句发送到数据库
            if (rs.next()) {
                String s = rs.getInt(1) + "," + rs.getInt(2) + "," + rs.getString(3) + "," + rs.getString(4);
                Log.d("MysqlTest", s);
                return true;
            } else {
                Log.d("MysqlTest", "查询失败");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();//抛出异常
        } finally {
            CommonUtils.closeConnection(rs, stmt, con);//4.关闭数据库
        }
        return false;
    }

}
