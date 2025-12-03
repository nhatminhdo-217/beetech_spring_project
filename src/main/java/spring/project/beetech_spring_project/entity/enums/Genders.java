package spring.project.beetech_spring_project.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum Genders {
    MALE(1),
    FEMALE(2),
    ;

    private final int value;

    Genders(int value) {
        this.value = value;
    }

    @JsonCreator
    public static Genders fromJson(String json) {
        try {
            int value = Integer.parseInt(json);

            return fromValue(value);
        }catch (NumberFormatException e){
            throw new NumberFormatException();
        }
    }

    public static Genders fromValue(int value) {
        for (Genders g : values()) {
            if (g.value == value) return g;
        }
        throw new IllegalArgumentException();
    }

}
