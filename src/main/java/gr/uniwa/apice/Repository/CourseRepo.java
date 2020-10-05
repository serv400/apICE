package gr.uniwa.apice.Repository;

import gr.uniwa.apice.Domain.Course;
import gr.uniwa.apice.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CourseRepo extends JpaRepository<Course,Integer> {
    List<Course> findAll();
    List<Course> findCoursesByStudent(Student student);
    Course findCourseByCourseId(int id);
}
