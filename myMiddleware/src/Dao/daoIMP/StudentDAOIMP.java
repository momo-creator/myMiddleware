package Dao.daoIMP;

import Dao.bean.Student;
import Dao.dao.StudentDAO;
import java.sql.*;
import java.util.ArrayList;

import Dao.connection.DataBaseConnection;

public class StudentDAOIMP implements StudentDAO{
    // 添加操作
    public void insert(Student s){
        String sql = "INSERT INTO student (id, name) values (?,?)";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        //针对数据库的具体操作
        try{
            conn = new DataBaseConnection();

            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setInt(1,s.getID());
            //pstmt.setString(1,s.getID());
            pstmt.setString(2,s.getName());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){  }
    }

    public void update(Student s){
        String sql = "UPDATE student set name = ? where id = ?";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        try{
            conn = new DataBaseConnection();
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setString(1,s.getName());
            pstmt.setInt(2,s.getID());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){  }
    }

    public void delete(int id){
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        String sql = "DELETE FROM student where id = ?";
        try{
            conn = new DataBaseConnection();
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> findAll() {
        ArrayList<Student> students = new ArrayList<Student>();
        String sql = "select * from student";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;

        try {
            conn = new DataBaseConnection();
            pstmt = conn.getConnection().prepareStatement(sql);

            //执行sql，返回结果集
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setID(rs.getInt("id"));
                student.setName(rs.getString("name"));

                students.add(student);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student findByID(int id){
        Student student = null;
        String sql = "SELECT * from student where id = ?";
        PreparedStatement pstmt = null;
        DataBaseConnection conn = null;
        try{
            conn = new DataBaseConnection();
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                student = new Student();
                student.setID(rs.getInt("id"));
                student.setName(rs.getString("name"));
            }
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

}

