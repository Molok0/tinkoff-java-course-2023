package edu.hw4_update;

public enum ValidationError {
    INVALID_AGE("Возраст меньше 0"),
    INVALID_HEIGHT("Рост меньше 0"),
    INVALID_WEIGHT("Вес меньше 0");

    private final String message;

    private ValidationError(String message){
        this.message = message;
    }

}
