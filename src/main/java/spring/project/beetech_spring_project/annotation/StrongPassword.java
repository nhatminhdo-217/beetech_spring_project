package spring.project.beetech_spring_project.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import spring.project.beetech_spring_project.annotation.validator.PasswordValidator;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordValidator.class})
public @interface StrongPassword {
    String message() default "Password must have at least characters";
    String pattern() default "^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).+$";

    int min() default 8;
    int max() default 32;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
