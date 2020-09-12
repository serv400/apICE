package gr.uniwa.apice.Service;

import gr.uniwa.apice.Domain.Student;

public interface StudentService {
    Student getStudentById(int id);
    void addStudent(Student student);
}
