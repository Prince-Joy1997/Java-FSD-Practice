package in.stackroute.ust.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class HomeController {

    @GetMapping("/welcome")
    public String greeting(){
        return "Welcome Home";
    }
}
