package gr.uniwa.apice.Repository;

import gr.uniwa.apice.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
        Student findStudentByUsername(String s);
}
