package spring.project.beetech_spring_project.service;

import org.springframework.stereotype.Service;
import spring.project.beetech_spring_project.entity.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class UserService {

    public void registerUser(User user) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            int yearOfBirth = LocalDate.parse(user.getDob(), dtf).getYear();

            if (yearOfBirth > LocalDate.now().getYear()) {
                throw new RuntimeException("exception.user.age.greater_than_now");
            }

            if (LocalDate.now().getYear() - yearOfBirth < 16) {
                throw new RuntimeException("exception.user.age.invalid");
            }

            int gender = Integer.parseInt(user.getGender());

            if (gender != 1 && gender != 2) {
                throw new RuntimeException("exception.user.gender.invalid");
            }
        }catch (DateTimeParseException dtpe) {
            throw new RuntimeException("exception.user.dob.parse");
        }catch (NumberFormatException nfe) {
            throw new RuntimeException("exception.user.gender.parse");
        }

    }
}
