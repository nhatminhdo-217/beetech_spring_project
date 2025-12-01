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
    @NotEmpty
    private String fullName;

    @NotEmpty
    @Email(regexp = "^\\S+@\\S+\\.\\S+$")
    private String email;

    @NotEmpty
    @Size(min = 8, max = 32)
    private String password;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String dob;

    @NotNull
    private String gender;
}
