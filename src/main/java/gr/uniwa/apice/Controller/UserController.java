package gr.uniwa.apice.Controller;

import gr.uniwa.apice.Domain.Course;
import gr.uniwa.apice.Domain.Student;
import gr.uniwa.apice.Enum.Courses;
import gr.uniwa.apice.Service.CourseService;
import gr.uniwa.apice.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

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

    @GetMapping("/user/{username}/courses/addCourse")
    public String addCourse(@PathVariable String username,Model model){
        model.addAttribute(studentService.getStudentByUsername(username));
        model.addAttribute("course",new Course());
        model.addAttribute("cDetails", Courses.values());
        return "newCourseForm";
    }

    @PostMapping(value ="/user/{username}/courses/addCourse")
    public String showAddedCourse(@ModelAttribute Course course , @PathVariable String username, Errors errors,Model model){
        if(errors.hasErrors()){
            return  "newCourseForm";
        }
        Student st = studentService.getStudentByUsername(username);
        model.addAttribute("courseAdded",course);
        studentService.addCourseToStudent(course,st);
        return "showCourse";
    }

    @GetMapping("/user/{username}/courses/listCourses")
    public String showUserCourses(@PathVariable String username ,Model model){
        Student st = studentService.getStudentByUsername(username);
        model.addAttribute("personalCourses",courseService.showAllCoursesOfStudent(st));
        return "listPersonalCourses";
    }
    @GetMapping("/user/{username}/courses/deleteCourse/{id}")
    public String deleteStudentCourse(@PathVariable String username ,Model model,@PathVariable int id){
        Student st = studentService.getStudentByUsername(username);
        courseService.deleteCourseOfStudent(st,id);
        model.addAttribute("personalCourses",courseService.showAllCoursesOfStudent(st));
        return "redirect:/user/{username}/courses/listCourses";
    }

    @GetMapping("/user/{username}/friends/{friendUsername}/courses/list")
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
