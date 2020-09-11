package gr.uniwa.apice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/")
    public String main(){
        return "welcome";
    }

    @GetMapping("/signup")
    public String newMember(){
        return "signup";
    }

}
