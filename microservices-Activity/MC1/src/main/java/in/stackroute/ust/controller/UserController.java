package in.stackroute.ust.controller;

import in.stackroute.ust.domain.User;
import in.stackroute.ust.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody User user){
        final var res = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if(res.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body("Login Successfull");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Credentials");
    }
}
