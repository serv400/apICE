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

    @GetMapping("/error")
    public String error(){
        return "error";
    }

    @RequestMapping(value = "/signup",method= RequestMethod.POST)
    public String saveStudent(Student student) throws Exception{
        try {
            studentService.addStudent(student);
            return "/user";
        }catch (Exception e){
            e.getMessage();
            return "/error";
        }
    }

}
