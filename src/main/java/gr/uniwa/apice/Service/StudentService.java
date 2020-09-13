package gr.uniwa.apice.Service;

import gr.uniwa.apice.Domain.Student;

public interface StudentService {
    Student getStudentById(int id);
    Student getStudentByUsername(String username);
    void addStudent(Student student);
}
