package gr.uniwa.apice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class IndexController {
    @GetMapping("/")
    public String home(){
        return ("<h1>Hi !!!!</h1>");
    }

    @GetMapping("/user")
    public String homeUSer(){
        return ("<h1>Hi user!!!!</h1>");
    }

    @GetMapping("/admin")
    public String homeAdmin(){
        return ("<h1>Hi admin!!!!</h1>");
    }
}
