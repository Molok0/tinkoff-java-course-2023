package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public final class Task1 {
    private static final int TO_HOURS = 3600;
    private static final int TO_MINUTES = 60;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

    private Task1() {

    }

    public static String averageTimeSession(List<String> times) {
        Long sumTime = Long.valueOf(0);
        int count = 0;
        for (String time : times) {
            String[] splitTime = time.split(" - ");
            LocalDateTime localDateTime = LocalDateTime.parse(splitTime[0], formatter);

            Duration duration = Duration.between(LocalDateTime.parse(splitTime[1], formatter), localDateTime);
            sumTime += Math.abs(duration.getSeconds());
            count += 1;
        }
        Long secondsAverageValue = sumTime / count;

        var h = (int) (secondsAverageValue / TO_HOURS);
        var m = (int) (secondsAverageValue % TO_HOURS / TO_MINUTES);

        return String.format("%dч %dм", h, m);
    }

}
