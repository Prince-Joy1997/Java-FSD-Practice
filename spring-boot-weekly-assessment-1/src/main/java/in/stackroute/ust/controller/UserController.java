package in.stackroute.ust.controller;

import in.stackroute.ust.domain.User;
import in.stackroute.ust.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    //Autowire using constructor
    @Autowired
    private UserRepository userRepository;

//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(user));
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        Optional<User> optuser = userRepository.findById(id);
        if (optuser.isEmpty()){
//            optuser.orElseThrow(()-> new RuntimeException("User not found")
//            );
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(optuser.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable long id, @RequestBody User user){
        Optional<User> optuser = userRepository.findById(id);
        optuser.get().setName(user.getName());
        optuser.get().setEmail(user.getEmail());
        optuser.get().setPassword(user.getPassword());
        final var out = userRepository.save(optuser.get());
        return ResponseEntity.status(HttpStatus.OK).body(out);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable long id){
        userRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
