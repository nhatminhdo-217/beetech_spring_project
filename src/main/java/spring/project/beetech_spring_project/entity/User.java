package spring.project.beetech_spring_project.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
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
    @NotEmpty(message = "Please enter full name")
    private String fullName;

    @NotEmpty(message = "Please enter email")
    @Email(regexp = "^\\S+@\\S+\\.\\S+$", message = "Your email do not match the email format. Eg: abc@example.com")
    private String email;

    @NotEmpty(message = "Please enter password")
    @Size(min = 8, message = "Password must have at least 8 character")
    private String password;

    @NotNull(message = "Please enter date of birth")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;

    @NotNull(message = "Please enter gender(1-male, 2-female)")
    private int gender;
}
