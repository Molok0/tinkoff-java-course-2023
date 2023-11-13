package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public abstract class StrongDateFormat{
    StrongDateFormat NextStrongDateFormat;

    public StrongDateFormat(){

    }
    public abstract Optional<LocalDate> parseDate(String string);

    public StrongDateFormat getNextStrongDateFormat() {
        return NextStrongDateFormat;
    }

    public void setNextStrongDateFormat(StrongDateFormat nextStrongDateFormat) {
        NextStrongDateFormat = nextStrongDateFormat;
    }
}
