package gr.uniwa.apice.Service;

import gr.uniwa.apice.Domain.Student;
import gr.uniwa.apice.Domain.TheoryCourse;
import gr.uniwa.apice.Repository.TheoryCourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheoryCourseServiceImpl implements  TheoryCourseService{

    @Autowired
    private TheoryCourseRepo theoryCourseRepo;

    @Override
    public List<TheoryCourse> showAllTheoryCoursesOfStudent(Student student) {
        return theoryCourseRepo.findTheoryCourseByStudent(student);
    }
}
