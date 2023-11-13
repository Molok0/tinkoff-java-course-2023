package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class NextFridays13th implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        LocalDate date = LocalDate.from(temporal).with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        while (date.getDayOfMonth() != 13) {
            date = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return date;
    }
}
