package gr.uniwa.apice.Service;

import gr.uniwa.apice.Domain.Student;
import gr.uniwa.apice.Domain.TheoryCourse;

import java.util.List;

public interface TheoryCourseService {
    List<TheoryCourse> showAllTheoryCoursesOfStudent(Student student);
    void deleteTheoryCourseOfStudent(Student st , int thCourseId);
}
