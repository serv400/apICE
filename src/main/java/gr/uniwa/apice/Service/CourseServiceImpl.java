package gr.uniwa.apice.Service;

import gr.uniwa.apice.Domain.Course;
import gr.uniwa.apice.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<Course> listAllCourses() {
        List<Course> courses = new ArrayList<>();
        courses = courseRepo.findAll();
        return courses;
    }

    @Override
    public void createCourses() {

    }
}
