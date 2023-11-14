package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public abstract class StrongDateFormat {
    StrongDateFormat nextStrongDateFormat;

    public StrongDateFormat() {

    }

    public abstract Optional<LocalDate> parseDate(String input);

    public StrongDateFormat getNextStrongDateFormat() {
        return nextStrongDateFormat;
    }

    public void setNextStrongDateFormat(StrongDateFormat nextStrongDateFormat) {
        this.nextStrongDateFormat = nextStrongDateFormat;
    }
}
