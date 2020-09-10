package gr.uniwa.apice.Service;

import gr.uniwa.apice.Repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepo courseRepo;
}
