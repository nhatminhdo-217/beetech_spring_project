package spring.project.beetech_spring_project.annotation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import spring.project.beetech_spring_project.annotation.ValidateGender;

public class GenderValidator implements ConstraintValidator<ValidateGender, String> {
    @Override
    public boolean isValid(String str, ConstraintValidatorContext context) {
        if (str == null || str.isEmpty()) {
            return true;
        }

        int gender;
        try {
            gender =  Integer.parseInt(str);
        }catch (NumberFormatException e){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{exception.user.gender.parse}").addConstraintViolation();
            return false;
        }

        if (gender < 0 || gender > 2) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{exception.user.gender.invalid}").addConstraintViolation();
            return false;
        }

        return true;
    }
}
