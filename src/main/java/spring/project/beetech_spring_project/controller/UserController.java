package spring.project.beetech_spring_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.project.beetech_spring_project.entity.User;

import java.time.LocalDate;

@RestController
public class UserController {

    @PostMapping("/user")
    public ResponseEntity<?> myPostMapping(@RequestBody User user) {

        return ResponseEntity.ok().build();
    }
}
