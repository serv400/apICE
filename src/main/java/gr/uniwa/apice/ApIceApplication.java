package gr.uniwa.apice;

import gr.uniwa.apice.Domain.Student;
import gr.uniwa.apice.Repository.StudentRepo;
import gr.uniwa.apice.Service.StudentService;
import gr.uniwa.apice.Service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApIceApplication /*implements CommandLineRunner*/ {
   /* @Autowired
    StudentService studentService;*/

    public static void main(String[] args) {
        SpringApplication.run(ApIceApplication.class, args);
    }

    /*@Override
    public void run(String... args) throws Exception {

        studentService.addStudent(new Student("Serafeim","Vasileiou","cs171072","serafeimv","password","ROLE_ADMIN"));

    }*/
}
