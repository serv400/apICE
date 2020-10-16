package gr.uniwa.apice.Service;

import gr.uniwa.apice.Domain.Course;
import gr.uniwa.apice.Domain.Student;
import gr.uniwa.apice.Domain.TheoryCourse;

import java.util.List;
import java.util.Set;

public interface StudentService {
    Student getStudentById(int id);
    Student getStudentByUsername(String username);
    void addStudent(Student student);
    List<Student> showAllStudents();
    Student findExactStudent(String am);
    void addCourseToStudent(Course course,Student student);
    void addTheoryCoursesToStudent(Set<TheoryCourse> courses, Student student);
    Student deleteStudentCourse(Course course);
    void deleteStudent(Student student);
}
