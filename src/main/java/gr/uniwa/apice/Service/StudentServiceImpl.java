package gr.uniwa.apice.Service;

import gr.uniwa.apice.Domain.Student;
import gr.uniwa.apice.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepo studentRepo;
}
