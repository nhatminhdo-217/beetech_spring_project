package spring.project.beetech_spring_project.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.project.beetech_spring_project.annotation.StrongPassword;
import spring.project.beetech_spring_project.annotation.ValidateDOB;
import spring.project.beetech_spring_project.annotation.ValidateGender;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotEmpty
    private String fullName;

    @NotEmpty
    @Email(regexp = "^\\S+@\\S+\\.\\S+$")
    private String email;

    @NotEmpty
    @StrongPassword
    private String password;

    @NotNull
    @ValidateDOB
    private String dob;

    @NotNull
    @ValidateGender
    private String gender;
}
