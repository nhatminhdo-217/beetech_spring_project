package spring.project.beetech_spring_project.entity;

import org.springframework.stereotype.Component;
import spring.project.beetech_spring_project.entity.enums.Genders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class UserMapper {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public User toEntity(UserDTO dto) {
        LocalDate dob = LocalDate.parse(dto.getDob(), dtf);
        int genderVal = Integer.parseInt(dto.getGender());

        return User.builder()
                .fullName(dto.getFullName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .dob(dob)
                .gender(Genders.fromValue(genderVal))
                .build();
    }

    public UserDTO toDTO(User model) {
        return UserDTO.builder()
                .fullName(model.getFullName())
                .email(model.getEmail())
                .password(model.getPassword())
                .dob(model.getDob().toString())
                .gender(model.getGender().name())
                .build();
    }
}
