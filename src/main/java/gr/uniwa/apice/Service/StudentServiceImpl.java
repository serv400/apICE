package gr.uniwa.apice.Service;

import gr.uniwa.apice.Domain.Student;
import gr.uniwa.apice.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
    public void addStudent(Student s) {
        s.setPassword(bCryptPasswordEncoder.encode(s.getPassword()));
        studentRepo.save(s);
    }
}
