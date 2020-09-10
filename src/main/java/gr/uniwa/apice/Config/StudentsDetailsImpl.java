package gr.uniwa.apice.Config;

import gr.uniwa.apice.Domain.Student;
import gr.uniwa.apice.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StudentsDetailsImpl  implements UserDetailsService {
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Student student = this.studentRepo.findStudentByUsername(s);

        if (student==null){
            throw  new UsernameNotFoundException(("Non available username"));
        }
        return new StudentDetails(student);
    }
}
