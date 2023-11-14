package edu.hw5.task3;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class StandardDateFormat extends StrongDateFormat {
    private static final DateTimeFormatter STANDARD = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public Optional<LocalDate> parseDate(String input) {
        try {
            LocalDate answer = LocalDate.parse(input, STANDARD);
            return Optional.of(answer);
        } catch (DateTimeException e) {

        }
        if (this.getNextStrongDateFormat() != null) {
            return this.getNextStrongDateFormat().parseDate(input);
        }
        return Optional.empty();
    }
}
