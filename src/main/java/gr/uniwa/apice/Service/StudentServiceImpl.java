package gr.uniwa.apice.Service;

import gr.uniwa.apice.Domain.Course;
import gr.uniwa.apice.Domain.Student;
import gr.uniwa.apice.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private CourseService courseService;

    @Override
    public Student getStudentById(int id) {
        Student student = studentRepo.findStudentByStudentId(id);
        return student;
    }

    @Override
    public Student getStudentByUsername(String username) {
        Student student = studentRepo.findStudentByUsername(username);
        return student;
    }

    @Override
    public void addStudent(Student s) {
        s.setPassword(bCryptPasswordEncoder.encode(s.getPassword()));
        studentRepo.save(s);
    }

    @Override
    public List<Student> showAllStudents() {
        return studentRepo.findStudentsByRoleOrderByCodeAsc("ROLE_USER");
    }

    @Override
    public Student findExactStudent(String am) {
        Student student = studentRepo.findStudentByCode(am);
        return student;
    }

    @Override
    public void addCourseToStudent(Course course, Student student) {
        course.setStudent(student);
        student.addCourseToSet(course);
        studentRepo.save(student);
    }

    @Override
    public Student deleteStudentCourse(Course course) {
       Student st = studentRepo.findStudentByCourseSetContains(course);
       st.getCourseSet().remove(course);
        return null;
    }


    @Override
    public void deleteStudent(Student student) {
        if (student.getCourseSet().size()!=0){
        courseService.deleteCoursesByStudent(student);
        }
        studentRepo.delete(student);
    }


}
