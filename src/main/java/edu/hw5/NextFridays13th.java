package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class NextFridays13th implements TemporalAdjuster {
    private static final int IS13TH = 13;

    @Override
    public Temporal adjustInto(Temporal temporal) {
        LocalDate date = LocalDate.from(temporal).with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        while (date.getDayOfMonth() != IS13TH) {
            date = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return date;
    }
}
