package gr.uniwa.apice.Controller;

import gr.uniwa.apice.Domain.Student;
import gr.uniwa.apice.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String main(){
        return "welcome";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/signup")
    public String addStudent(Model model){
        model.addAttribute("student",new Student());
        return "signup";
    }

    @GetMapping("/registration-error")
    public String error(){
        return "registration-error";
    }

    @GetMapping("/registration-successful")
    public String success(){
        return "registration-successful";
    }

    @RequestMapping(value = "/signup",method= RequestMethod.POST)
    public String saveStudent(Student student){
        try {
            studentService.addStudent(student);
            return "registration-successful";
        }catch (Exception e){
            e.getMessage();
            return "registration-error";
        }
    }

}
