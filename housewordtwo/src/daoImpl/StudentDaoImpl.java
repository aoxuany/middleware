package daoImpl;
import model.Student;
import dao.StudentDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connection.Connect;

public class StudentDaoImpl implements StudentDao{
    // 添加操作
    public void insert(Student s){
        String sql = "INSERT INTO student (id, name) values (?,?)";
        PreparedStatement pstmt = null;
        Connect conn = null;
        //针对数据库的具体操作
        try{
            conn = new Connect();
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setLong(1,s.getID());
            //pstmt.setString(1,s.getID());
            pstmt.setString(2,s.getName());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }
        catch(Exception e){  }
    }

    public void update(Student s){
        PreparedStatement pstmt;
        try {
        Connect conn = new Connect();
        String sql = "UPDATE student SET name = ? WHERE id = ?";
        pstmt = conn.getConnection().prepareStatement(sql);
        pstmt.setLong(1,s.getID());
        pstmt.setString(2,s.getName());
        pstmt.execute();
    } catch (SQLException e) {
        e.printStackTrace();
        }
    }

    public void delete(String iD){
        PreparedStatement pstmt;
        try {
            Connect conn = new Connect();
            String sql = "DELETE FROM student WHERE id = ?";
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setLong(1, Long.parseLong(iD));
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> findAll(){
        List<Student> students = new ArrayList<>();
        PreparedStatement pstmt;
        try {
            Connect conn = new Connect();
            String sql = "SELECT * FROM student";
            pstmt = conn.getConnection().prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            while(resultSet.next()) {
                students.add(new Student(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student findByID(long iD){
        Student student = null;
        PreparedStatement pstmt;
        try {
            Connect conn = new Connect();
            String sql = "SELECT * FROM student WHERE id = ?";
            pstmt = conn.getConnection().prepareStatement(sql);
            pstmt.setInt(1, (int) iD);
            ResultSet resultSet = pstmt.executeQuery();
            resultSet.next();
            student = new Student(resultSet.getInt("id"), resultSet.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

}

