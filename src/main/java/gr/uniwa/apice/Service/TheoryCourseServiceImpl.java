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
    @Autowired
    private StudentService studentService;


    @Override
    public List<TheoryCourse> showAllTheoryCoursesOfStudent(Student student) {
        return theoryCourseRepo.findTheoryCourseByStudent(student);
    }
    @Override
    public void deleteTheoryCourseOfStudent(Student st, int thCourseId) {
        TheoryCourse theoryCourse = theoryCourseRepo.findTheoryCourseByTheoryCourseId(thCourseId);
        studentService.deleteTheoryCourse(theoryCourse);
        theoryCourseRepo.delete(theoryCourse);
    }
}
