package spring.project.beetech_spring_project.annotation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import spring.project.beetech_spring_project.annotation.ValidateType;
import spring.project.beetech_spring_project.entity.enums.Genders;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TypeValidator implements ConstraintValidator<ValidateType, String> {

    private int[] values;
    private final MessageSource messageSource;

    public TypeValidator(int[] values, MessageSource messageSource) {
        this.values = values;
        this.messageSource = messageSource;
    }

    @Override
    public void initialize(ValidateType constraintAnnotation) {
        this.values = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(String gen, ConstraintValidatorContext context) {
        if (gen == null) {
            return true;
        }

        int input;

        try {
            input =  Integer.parseInt(gen);
        }catch (NumberFormatException e){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{exception.userDTO.gender.parse}").addConstraintViolation();
            return false;
        }

        if (Arrays.stream(values).noneMatch(value -> value == input)) {

            String allowed = Arrays.stream(values)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(", "));

            String msg = messageSource.getMessage(
                    "exception.userDTO.input.invalid",
                    new Object[] {allowed},
                    LocaleContextHolder.getLocale());

            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(msg).addConstraintViolation();
            return false;
        }

        return true;
    }
}
