package in.stackroute.ust.controller;

import in.stackroute.ust.domain.User;
import in.stackroute.ust.service.UserPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
@Autowired
private UserPersistenceService userPersistenceService;

    // GET /api/v1/users?email=email

    // GET /api/v1/users?email=email&password=password

    @GetMapping("/search")
    public ResponseEntity<User> findEmail(@RequestParam String email){
        Optional<User> out = userPersistenceService.findByEmail(email);
        if (out.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(out.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("")
    public ResponseEntity<User> findEmailPassword(@RequestParam String email, @RequestParam String password){
        Optional<User> res = userPersistenceService.findByEmailAndPassword(email,password);
        if (res.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(res.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
