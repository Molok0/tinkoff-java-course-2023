package edu.hw5.task3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class NotStandardDateFormat extends StrongDateFormat {
    private static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-d");
    List<SimpleDateFormat> list = List.of(
        new SimpleDateFormat("yyyy-MM-d"),
        new SimpleDateFormat("yyyy-M-d"),
        new SimpleDateFormat("yyyy-M-dd"),
        new SimpleDateFormat("dd-MM-yyyy"),
        new SimpleDateFormat("dd-MM-yy")
    );

    @Override
    public Optional<LocalDate> parseDate(String string) {
        return Optional.empty();
    }
}
