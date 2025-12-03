package spring.project.beetech_spring_project.entity;

import jakarta.validation.constraints.*;
import lombok.*;
import spring.project.beetech_spring_project.annotation.StrongPassword;
import spring.project.beetech_spring_project.annotation.ValidateDOB;
import spring.project.beetech_spring_project.annotation.ValidateType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {
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
    @ValidateType(values = {1, 2})
    private String gender;
}
