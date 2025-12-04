package spring.project.beetech_spring_project.entity;

import lombok.*;
import spring.project.beetech_spring_project.entity.enums.Genders;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    private String fullName;
    private String email;
    private String password;
    private LocalDate dob;
    private Genders gender;
}
