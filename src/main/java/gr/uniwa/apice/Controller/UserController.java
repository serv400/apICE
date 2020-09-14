package gr.uniwa.apice.Controller;

import gr.uniwa.apice.Domain.Student;
import gr.uniwa.apice.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private StudentService studentService;

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
    @RequestMapping("/user/{username}/friends/addFriend")
    public String addFriend(@PathVariable String username,Model model){
       model.addAttribute(studentService.getStudentByUsername(username));
        model.addAttribute("student",new Student());
        return "newFriendForm";
    }
    @RequestMapping(value ="/user/{username}/friends/addFriend",method= RequestMethod.POST)
    public String saveFriend(@PathVariable String username,Student student){
         studentService.getStudentByUsername(username);
            studentService.addFriend(studentService.getStudentByUsername(username),student);
            return "listFriends";

    }
    @GetMapping("/user/{username}/friends/listFriends")
    public String listFriends(@PathVariable String username,Model model){
        model.addAttribute(studentService.getStudentByUsername(username));
        model.addAttribute("friends",studentService.showAllFriends(studentService.getStudentByUsername(username)));
        return "listFriends";
    }
    @GetMapping("/user/{username}/courses")
    public String courseMenu(@PathVariable String username,Model model){
        model.addAttribute("student",studentService.getStudentByUsername(username));
        return "course-menu";
    }
}
