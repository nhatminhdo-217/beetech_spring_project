package spring.project.beetech_spring_project.annotation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import spring.project.beetech_spring_project.annotation.StrongPassword;

public class PasswordValidator implements ConstraintValidator<StrongPassword, String> {

    private String pattern;
    private int min;
    private int max;

    @Override
    public void initialize(StrongPassword constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext context) {

        if (str == null || str.isEmpty()) {
            return true;
        }

        //Check if the input password is > 8 and < 32 char
        if (str.length() < min || str.length() > max) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{validation.userDTO.password.size}").addConstraintViolation();
            return false;
        }

        if (!str.matches(pattern)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{validation.userDTO.password.match}").addConstraintViolation();
            return false;
        }

        return true;
    }
}
