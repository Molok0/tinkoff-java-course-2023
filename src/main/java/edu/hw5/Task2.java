package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static List<String> getAllFridays(int year) {
        List<String> allFridays = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            LocalDate localDate = LocalDate.of(year, i, 13);
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
