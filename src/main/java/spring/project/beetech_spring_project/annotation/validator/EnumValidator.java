package spring.project.beetech_spring_project.annotation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import spring.project.beetech_spring_project.annotation.EnumValidate;
import spring.project.beetech_spring_project.entity.enums.Genders;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumValidator implements ConstraintValidator<EnumValidate, String> {

    Set<String> values;
    private final MessageSource messageSource;

    public EnumValidator(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void initialize(EnumValidate constraintAnnotation) {
        values = Stream.of(constraintAnnotation.enumType().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true;
        }

        int input;
        Genders genders;

        try {
            input = Integer.parseInt(value);
        }catch (NumberFormatException e){
            return true;
        }

        try {
            genders = Genders.fromValue(input);
        }catch (IllegalArgumentException e){

            String allowed = String.join(", ", values);

            String msg = messageSource.getMessage(
                    "exception.userDTO.input.invalid",
                    new Object[] {allowed},
                    LocaleContextHolder.getLocale());

            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(msg).addConstraintViolation();
            return false;
        }

        return values.contains(genders.name());
    }
}
