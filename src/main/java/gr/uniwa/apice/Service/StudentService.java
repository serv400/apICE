package gr.uniwa.apice.Service;

import gr.uniwa.apice.Domain.Student;

import java.util.List;

public interface StudentService {
    Student getStudentById(int id);
    Student getStudentByUsername(String username);
    void addStudent(Student student);
    void addFriend(Student studentA,Student studentB);
    List<Student> showAllFriends(Student student);
}
