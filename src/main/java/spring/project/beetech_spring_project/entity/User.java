package spring.project.beetech_spring_project.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String fullName;
    private String email;
    private String password;
    private LocalDate dob;
    private Boolean gender;
}
