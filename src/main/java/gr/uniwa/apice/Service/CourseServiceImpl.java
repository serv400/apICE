package gr.uniwa.apice.Service;

import gr.uniwa.apice.Domain.Course;
import gr.uniwa.apice.Domain.Student;
import gr.uniwa.apice.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private StudentService studentService;

    @Override
    public Course saveCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public List<Course> showAllCoursesOfStudent(Student student) {
        return courseRepo.findCoursesByStudent(student);
    }

    @Override
    public void deleteCoursesByStudent(Student student) {
        List<Course> courseList =courseRepo.findCoursesByStudent(student);
            courseList.clear();
    }

    @Override
    public void deleteCourseOfStudent(Student st,int courseId) {
       Course course = courseRepo.findCourseByCourseId(courseId);
       studentService.deleteStudentCourse(course);
       courseRepo.delete(course);
    }


}
