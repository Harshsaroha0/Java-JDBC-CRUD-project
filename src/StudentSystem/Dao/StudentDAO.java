package StudentSystem.Dao;

import StudentSystem.model.Student;
import StudentSystem.util.DBConnection;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    // ADD
    public void addStudent(Student s) throws Exception {

        Connection con = DBConnection.getConnection();

        String query = "INSERT INTO student(id,name) VALUES(?,?)";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, s.getId());
        ps.setString(2, s.getName());

        ps.executeUpdate();

        con.close();
    }

    // DISPLAY
    public List<Student> getAllStudents() throws Exception {

        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM student";

        PreparedStatement ps = con.prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        List<Student> list = new ArrayList<>();

        while(rs.next()) {
            list.add(new Student(
                rs.getInt("id"),
                rs.getString("name")
            ));
        }

        con.close();

        return list;
    }

    // SEARCH
    public Student getStudentById(int id) throws Exception {

        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM student WHERE id=?";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            return new Student(
                rs.getInt("id"),
                rs.getString("name")
            );
        }

        return null;
    }

    // UPDATE
    public void updateStudent(Student s) throws Exception {

        Connection con = DBConnection.getConnection();

        String query = "UPDATE student SET name=? WHERE id=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setString(1, s.getName());
        ps.setInt(2, s.getId());

        ps.executeUpdate();

        con.close();
    }

    // DELETE
    public void deleteStudent(int id) throws Exception {

        Connection con = DBConnection.getConnection();

        String query = "DELETE FROM student WHERE id=?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);

        ps.executeUpdate();

        con.close();
    }
}