package spring.project.beetech_spring_project.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import spring.project.beetech_spring_project.annotation.validator.EnumValidator;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = {EnumValidator.class})
public @interface EnumValidate {
    Class<? extends Enum<?>> enumType();
    String message() default "Must be any of enum";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
