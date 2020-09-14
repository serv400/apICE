package gr.uniwa.apice.Service;

import gr.uniwa.apice.Domain.Course;

import java.util.List;

public interface CourseService {
    List<Course> listAllCourses();
    void createCourses();
}
