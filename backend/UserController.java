package com.example.firstFrontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // POST: Save a new user
    @PostMapping("/api/create")
    public ResponseEntity<String> createUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String university) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setUniversity(university);
        userRepository.save(user); // Save user to the database
        return ResponseEntity.ok("User created successfully!");
         
    }

    // GET: Retrieve all users
    @GetMapping("/api/user")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
}



