package gr.uniwa.apice.Service;

import gr.uniwa.apice.Domain.Student;
import gr.uniwa.apice.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student getStudentById(int id) {
        Student student = studentRepo.findStudentByStudentId(id);
        return student;
    }

    @Override
    public Student getStudentByUsername(String username) {
        Student student = studentRepo.findStudentByUsername(username);
        return student;
    }

    @Override
    public void addStudent(Student s) {
        s.setPassword(bCryptPasswordEncoder.encode(s.getPassword()));
        studentRepo.save(s);
    }

    @Override
    public void addFriend(Student studentA,Student studentB) {
        if (studentRepo.findStudentByCodeAndFnameAndLname(studentB.getCode(),
                studentB.getFname(),
                studentB.getLname())!=null ){
            studentA.getFriends().add(studentB);
            for (Student s : studentA.getFriends())
            System.out.println(s.getFname());
        }
        else
            System.out.println("Not found");
    }

    @Override
    public List<Student> showAllFriends(Student student) {
        List<Student> friends = new ArrayList<>();
        friends.addAll(studentRepo.findStudentByCode(student.getCode()).getFriends());
       return friends;
    }


}
