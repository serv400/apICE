package gr.uniwa.apice.Repository;

import gr.uniwa.apice.Domain.Student;
import gr.uniwa.apice.Domain.TheoryCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheoryCourseRepo extends JpaRepository<TheoryCourse,Integer> {
    List<TheoryCourse> findTheoryCourseByStudent(Student student);
}
