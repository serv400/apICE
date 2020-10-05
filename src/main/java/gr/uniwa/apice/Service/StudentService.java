package gr.uniwa.apice.Service;

import gr.uniwa.apice.Domain.Course;
import gr.uniwa.apice.Domain.Student;

import java.util.List;

public interface StudentService {
    Student getStudentById(int id);
    Student getStudentByUsername(String username);
    void addStudent(Student student);
    List<Student> showAllStudents();
    Student findExactStudent(String am);
    void addCourseToStudent(Course course,Student student);
    Student deleteStudentCourse(Course course);
    void deleteStudent(Student student);
}
