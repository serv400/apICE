package gr.uniwa.apice.Service;

import gr.uniwa.apice.Domain.Course;
import gr.uniwa.apice.Domain.Student;

import java.util.List;
import java.util.Set;

public interface CourseService {
    Course saveCourse(Course course);
    List<Course> showAllCoursesOfStudent(Student student);
}
