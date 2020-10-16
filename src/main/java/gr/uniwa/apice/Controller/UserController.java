package gr.uniwa.apice.Controller;

import gr.uniwa.apice.Domain.Course;
import gr.uniwa.apice.Domain.Student;
import gr.uniwa.apice.Domain.TheoryCourse;
import gr.uniwa.apice.Enum.Courses;
import gr.uniwa.apice.Enum.TheoryCourses;
import gr.uniwa.apice.Service.CourseService;
import gr.uniwa.apice.Service.StudentService;
import gr.uniwa.apice.Service.TheoryCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TheoryCourseService theoryCourseService;

    @GetMapping("/user/{username}")
    public String homeUSer(@PathVariable String username,Model model){
        model.addAttribute("student",studentService.getStudentByUsername(username));
        return "user";
    }
    @GetMapping("/user/{username}/friends")
    public String friendMenu(@PathVariable String username,Model model){
        model.addAttribute("student",studentService.getStudentByUsername(username));
        return "friend-menu";
    }
    @RequestMapping("/user/{username}/friends/searchFriend")
    public String addFriend(@PathVariable String username,Model model){
       model.addAttribute(studentService.getStudentByUsername(username));
        model.addAttribute("student",new Student());
        return "newFriendForm";
    }
    @RequestMapping(value ="/user/{username}/friends/searchFriend",method= RequestMethod.POST)
    public String showExactFriend(@PathVariable String username,Model model,Student student){
         model.addAttribute(studentService.getStudentByUsername(username));
         model.addAttribute("friends",studentService.findExactStudent(student.getCode()));
            return "listFriends";
    }
    @GetMapping("/user/{username}/friends/listAllFriends")
    public String listFriends(@PathVariable String username,Model model){
        model.addAttribute(studentService.getStudentByUsername(username));
        model.addAttribute("students",studentService.showAllStudents());
        return "listAllFriends";
    }
    @GetMapping("/user/{username}/courses")
    public String courseMenu(@PathVariable String username,Model model){
        model.addAttribute("student",studentService.getStudentByUsername(username));
        return "course-menu";
    }
    @GetMapping("/user/{username}/courses/lab")
    public String courseLabMenu(@PathVariable String username,Model model){
        model.addAttribute("student",studentService.getStudentByUsername(username));
        return "course-lab-menu";
    }
    @GetMapping("/user/{username}/courses/theory")
    public String courseTheoryMenu(@PathVariable String username,Model model){
        model.addAttribute("student",studentService.getStudentByUsername(username));
        return "course-theory-menu";
    }
  /*  @GetMapping("/user/{username}/courses/theory/addCourse")
    public String addTheoryCourse(@PathVariable String username,Model model){
        model.addAttribute(studentService.getStudentByUsername(username));
        model.addAttribute("course",new TheoryCourse());
        model.addAttribute("cDetails", TheoryCourses.values());
        return "newTheoryCourseForm";
    }

    @PostMapping(value ="/user/{username}/courses/theory/addCourse")
    public String showAddedTheoryCourse(@ModelAttribute Set<TheoryCourse> courses ,
                                        @PathVariable String username, Errors errors){
        if(errors.hasErrors()){
            return  "newTheoryCourseForm";
        }
        Student st = studentService.getStudentByUsername(username);
        if (course!=null){

            studentService.addTheoryCoursesToStudent();
            return "listPersonalTheoryCourses";
        }
        else
            return "redirect:/user/{username}/courses/theory";
    }*/
    @GetMapping("/user/{username}/courses/lab/addCourse")
    public String addCourse(@PathVariable String username,Model model){
        model.addAttribute(studentService.getStudentByUsername(username));
        model.addAttribute("course",new Course());
        model.addAttribute("cDetails", Courses.values());
        return "newCourseForm";
    }

    @PostMapping(value ="/user/{username}/courses/lab/addCourse")
    public String showAddedCourse(@ModelAttribute Course course , @PathVariable String username, Errors errors,Model model){
        if(errors.hasErrors()){
            return  "newCourseForm";
        }
        Student st = studentService.getStudentByUsername(username);
        model.addAttribute("courseAdded",course);
        studentService.addCourseToStudent(course,st);
        return "showCourse";
    }

    @GetMapping("/user/{username}/courses/lab/listCourses")
    public String showUserCourses(@PathVariable String username ,Model model){
        Student st = studentService.getStudentByUsername(username);
        model.addAttribute("personalCourses",courseService.showAllCoursesOfStudent(st));
        return "listPersonalCourses";
    }
    @GetMapping("/user/{username}/courses/theory/listCourses")
    public String showUserTheoryCourses(@PathVariable String username ,Model model){
        Student st = studentService.getStudentByUsername(username);
        model.addAttribute("personalCourses",theoryCourseService.showAllTheoryCoursesOfStudent(st));
        return "listPersonalTheoryCourses";
    }
    @GetMapping("/user/{username}/courses/deleteCourse/{id}")
    public String deleteStudentCourse(@PathVariable String username ,Model model,@PathVariable int id){
        Student st = studentService.getStudentByUsername(username);
        courseService.deleteCourseOfStudent(st,id);
        model.addAttribute("personalCourses",courseService.showAllCoursesOfStudent(st));
        return "redirect:/user/{username}/courses/lab/listCourses";
    }

    @GetMapping("/user/{username}/friends/{friendUsername}/courses/lab/list")
    public String showFriendCourse(@PathVariable String username ,@PathVariable String friendUsername,Model model){
        studentService.getStudentByUsername(username);
        Student friend = studentService.getStudentByUsername(friendUsername);
        model.addAttribute("friendCourses",courseService.showAllCoursesOfStudent(friend));
        return "listFriendCourses";
    }

    @GetMapping("/user/{username}/options")
    public String showOptions(@PathVariable String username,Model model){
        model.addAttribute("student",studentService.getStudentByUsername(username));
        return "userOptions";
    }

    @GetMapping("/user/{username}/options/deleteAccount")
    public String deleteUser(@PathVariable String username){
        studentService.deleteStudent(studentService.getStudentByUsername(username));
        return "redirect:/";
    }

}
