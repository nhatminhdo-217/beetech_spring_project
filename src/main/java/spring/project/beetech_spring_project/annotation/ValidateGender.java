package spring.project.beetech_spring_project.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import spring.project.beetech_spring_project.annotation.validator.GenderValidator;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = GenderValidator.class)
public @interface ValidateGender {
    String message() default "Invalid Gender";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
