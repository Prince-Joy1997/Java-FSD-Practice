package in.stackroute.simplespringsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping({"/index"})
    public String index() {
        return "Welcome to the Index Page";
    }

    @GetMapping({"/user"})
    public String user() {
        return "Welcome to the user Page";
    }

    @GetMapping({"/admin"})
    public String admin() {
        return "Welcome to the Admin Page";
    }
}
