package StudentSystem.service;

import java.util.List;

import StudentSystem.Dao.StudentDAO;
import StudentSystem.model.Student;

public class StudentService {

    StudentDAO dao = new StudentDAO();

    public void add(Student s) throws Exception {
        dao.addStudent(s);
    }

    public List<Student> getAll() throws Exception {
        return dao.getAllStudents();
    }

    public Student getById(int id) throws Exception {
        return dao.getStudentById(id);
    }

    public void update(Student s) throws Exception {
        dao.updateStudent(s);
    }

    public void delete(int id) throws Exception {
        dao.deleteStudent(id);
    }
}