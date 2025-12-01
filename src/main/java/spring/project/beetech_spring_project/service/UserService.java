package spring.project.beetech_spring_project.service;

import org.springframework.stereotype.Service;
import spring.project.beetech_spring_project.entity.User;

import java.time.LocalDate;

@Service
public class UserService {

    public void registerUser(User user) {
        if (LocalDate.now().getYear() - user.getDob().getYear() < 16) {
            throw new RuntimeException("exception.user.age.invalid");
        }

        if (user.getGender() != 1 && user.getGender() != 2) {
            throw new RuntimeException("exception.user.gender.invalid");
        }
    }
}
