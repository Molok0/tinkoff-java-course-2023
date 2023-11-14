package edu.hw5.task3;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class NotStandardDateFormat extends StrongDateFormat {
    List<DateTimeFormatter> listOfFormat = List.of(
        DateTimeFormatter.ofPattern("yyyy-MM-d"),
        DateTimeFormatter.ofPattern("yyyy-M-d"),
        DateTimeFormatter.ofPattern("yyyy-M-dd"),
        DateTimeFormatter.ofPattern("dd-MM-yyyy"),
        DateTimeFormatter.ofPattern("dd-MM-yy"),
        DateTimeFormatter.ofPattern("yyyy/MM/d"),
        DateTimeFormatter.ofPattern("yyyy/M/d"),
        DateTimeFormatter.ofPattern("yyyy/M/dd"),
        DateTimeFormatter.ofPattern("dd/MM/yyyy"),
        DateTimeFormatter.ofPattern("dd/MM/yy"),
        DateTimeFormatter.ofPattern("d/MM/yyyy"),
        DateTimeFormatter.ofPattern("d/M/yyyy")
    );

    @Override
    public Optional<LocalDate> parseDate(String input) {
        LocalDate dateFormatter;
        for (DateTimeFormatter formatter : listOfFormat) {
            try {
                dateFormatter = LocalDate.parse(input, formatter);
                return Optional.of(dateFormatter);
            } catch (DateTimeException e) {
            }
        }
        if (this.getNextStrongDateFormat() != null) {
            return this.getNextStrongDateFormat().parseDate(input);

        }
        return Optional.empty();
    }
}
