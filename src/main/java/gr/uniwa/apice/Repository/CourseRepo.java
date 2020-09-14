package gr.uniwa.apice.Repository;

import gr.uniwa.apice.Domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course,Integer> {
    List<Course> findAll();
}
