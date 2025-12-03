package spring.project.beetech_spring_project.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import spring.project.beetech_spring_project.annotation.validator.TypeValidator;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = TypeValidator.class)
public @interface ValidateType {
    String message() default "Invalid Gender";

    int[] values() default {0};

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
