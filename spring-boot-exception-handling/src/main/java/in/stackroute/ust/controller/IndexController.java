package in.stackroute.ust.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping({"/index", "/home", "/", ""})
    public ResponseEntity<Map<String, String>> index() {
        logger.trace("Trace message");
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warn message");
        logger.error("Error message");
        return ResponseEntity.ok(Map.of("message", "Hello world!"));
    }

    @GetMapping("/{userName}")
    public ResponseEntity<Map<String, String>> index(@PathVariable String userName) {
        logger.debug("Accessing index with user name: " + userName);
        return ResponseEntity.ok(Map.of("message", "Hello " + userName));
    }

    // GET /api/v1/firstName=John&lastName=Doe
    @GetMapping("/")
    public ResponseEntity<Map<String, String>> greet(@RequestParam String firstName,
                                                     @RequestParam String lastName) {
        return ResponseEntity.ok(Map.of("message", "Hello " + firstName + " " + lastName));
    }

}
