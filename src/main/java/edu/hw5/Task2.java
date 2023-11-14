package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Task2 {

    private static final int COUNT_MONTHS_PLUS_ONE = 13;

    private Task2() {
    }

    public static List<String> getAllFridays(int year) {
        List<String> allFridays = new ArrayList<>();
        for (int i = 1; i < COUNT_MONTHS_PLUS_ONE; i++) {
            LocalDate localDate = LocalDate.of(year, i, COUNT_MONTHS_PLUS_ONE);
            if (localDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                allFridays.add(localDate.toString());
            }
        }
        return allFridays;
    }

    public static LocalDate getNextFridays(LocalDate date) {
        return date.with(new NextFridays13th());
    }

}
