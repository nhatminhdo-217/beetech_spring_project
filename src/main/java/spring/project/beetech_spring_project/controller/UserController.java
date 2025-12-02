package spring.project.beetech_spring_project.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.project.beetech_spring_project.entity.User;
import spring.project.beetech_spring_project.service.UserService;

import java.time.LocalDate;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> myPostMapping(
            @RequestBody @Valid User user
    ) {

        userService.registerUser(user);

        return ResponseEntity.ok().body(user);
    }
}
