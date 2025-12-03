package spring.project.beetech_spring_project.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import spring.project.beetech_spring_project.annotation.validator.DobValidator;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DobValidator.class)
public @interface ValidateDOB {
    String message() default "Invalid DOB";
    String pattern() default "dd/MM/yyyy";
    int minAge() default 16;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
