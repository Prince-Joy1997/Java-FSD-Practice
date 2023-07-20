package in.stackroute.ust.controller;

import in.stackroute.ust.domain.Arithmetic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")


public class MathController {

    @GetMapping("/add/{n1}/{n2}")
    public Arithmetic add(@PathVariable int n1, @PathVariable int n2) {
        return new Arithmetic(n1, n2, (n1 + n2), "+");
    }

    @GetMapping("/sub/{n1}/{n2}")
    public Arithmetic sub(@PathVariable int n1, @PathVariable int n2) {
        return new Arithmetic(n1, n2, (n1 - n2), "-");
    }

    @GetMapping("/mul/{n1}/{n2}")
    public Arithmetic mul(@PathVariable int n1, @PathVariable int n2) {
        return new Arithmetic(n1, n2, (n1 * n2), "*");
    }

    @GetMapping("/div/{n1}/{n2}")
    public Arithmetic div(@PathVariable int n1, @PathVariable int n2) {
        return new Arithmetic(n1, n2, (n1 == 0 && n2 == 0 ? 0 : n1 / n2), "/");
    }
}
