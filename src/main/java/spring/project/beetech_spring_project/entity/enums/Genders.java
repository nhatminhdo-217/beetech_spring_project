package spring.project.beetech_spring_project.entity.enums;

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

    // Thêm hàm này
    public static Genders fromValue(int value) {
        for (Genders gender : Genders.values()) {
            if (gender.getValue() == value) {
                return gender;
            }
        }
        throw new IllegalArgumentException("Invalid Gender Value: " + value);
    }
}
