package spring.project.beetech_spring_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class UserController {

    @PostMapping("/user")
    public ResponseEntity<?> myPostMapping(
            @RequestParam String fullName,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam LocalDate dob,
            @RequestParam Boolean gender) {

        return ResponseEntity.ok().build();
    }
}
