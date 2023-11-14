package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class Task3 {
    public Optional<LocalDate> parseDate(String input) {
        StrongDateFormat daysFormatter = new DayDateFormat();
        StrongDateFormat nonStandard = new NotStandardDateFormat();
        StrongDateFormat standard = new StandardDateFormat();

        daysFormatter.setNextStrongDateFormat(nonStandard);
        nonStandard.setNextStrongDateFormat(standard);
        standard.setNextStrongDateFormat(null);
        return daysFormatter.parseDate(input);
    }
}
