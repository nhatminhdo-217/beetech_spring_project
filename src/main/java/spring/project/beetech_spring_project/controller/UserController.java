package spring.project.beetech_spring_project.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.project.beetech_spring_project.entity.User;

import java.time.LocalDate;

@RestController
public class UserController {

    @PostMapping("/user")
    public ResponseEntity<?> myPostMapping(
            @RequestBody @Valid User user,
            BindingResult bindingResult
    ) {

        if (LocalDate.now().getYear() - user.getDob().getYear() < 16) {
            return ResponseEntity.badRequest().body("User must be greater than 16 years old to register");
        }

        if (user.getGender() != 1 && user.getGender() != 2) {
            return ResponseEntity.badRequest().body("Gender must be 1 or 2");
        }

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }

        return ResponseEntity.ok().body(user);
    }
}
