package gr.uniwa.apice.Controller;

import gr.uniwa.apice.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/user/{username}")
    public String homeUSer(@PathVariable String username,Model model){
        model.addAttribute("student",studentService.getStudentByUsername(username));
        return "user";
    }

}
