package gr.uniwa.apice.Controller;

import gr.uniwa.apice.Domain.Student;
import gr.uniwa.apice.PasswordGen.Generator;
import gr.uniwa.apice.Service.NotificationService;
import gr.uniwa.apice.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WelcomeController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private NotificationService notificationService;

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

    @GetMapping("/forgotPswd")
    public String forgotPassword(){
        return "forgotPswdForm";
    }
    @PostMapping("/forgotPswd")
    public String searchUser(String username,String userAM,String userMail)  {
            if(studentService.getStudentByUsernameAndID(username,userAM)!=null){
                Generator g = new Generator();
                Student studentChanged = new Student();
                String newPass = g.generatePwd();
                studentChanged.setPassword(newPass);
                System.out.println(studentChanged.toString());
                System.out.println(studentService.getStudentByUsernameAndID(username,userAM).toString());
                studentService.updateCurrentStudentPassword(studentService.getStudentByUsernameAndID(username,userAM),studentChanged);
                notificationService.sendNot(userMail,newPass);
                return "update-successful";
            }
            else
                return "registration-error";
    }


}
