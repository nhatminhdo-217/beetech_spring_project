package spring.project.beetech_spring_project.annotation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import spring.project.beetech_spring_project.annotation.ValidateDOB;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DobValidator implements ConstraintValidator<ValidateDOB, String> {

    private String pattern;
    private int minAge;

    @Override
    public void initialize(ValidateDOB constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
        this.minAge = constraintAnnotation.minAge();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        LocalDate localDate;

        //Check a date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            localDate = LocalDate.parse(s, formatter);
        }catch (DateTimeParseException e) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{validation.user.date.format}").addConstraintViolation();
            return false;
        }

        //Check if the input date is the past
        if (localDate.isAfter(LocalDate.now())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{validation.user.date.past}").addConstraintViolation();
            return false;
        }

        //Check if the input date year is greater than 16
        if (Period.between(localDate, LocalDate.now()).getYears() < minAge) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{validation.user.date.adult}").addConstraintViolation();
            return false;
        }

        return true;
    }
}
