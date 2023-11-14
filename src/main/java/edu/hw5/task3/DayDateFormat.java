package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Pattern;

public class DayDateFormat extends StrongDateFormat {
    private static final String DAY_AGO = "day ago";
    private static final String DAYS_AGO = "days ago";
    private static final String WEEKS_AGO = "weeks ago";
    private static final String MONTHS_AGO = "months ago";
    private static final String YEARS_AGO = "years ago";
    private static final String DAY_LATER = "day later";
    private static final String DAYS_LATER = "days later";
    private static final String WEEKS_LATER = "weeks later";
    private static final String MONTHS_LATER = "months later";
    private static final String MONTH_LATER = "month later";
    private static final String YEARS_LATER = "years later";

    private static final String TOMORROW = "tomorrow";
    private static final String TODAY = "today";
    private static final String YESTERDAY = "yesterday";
    private static final String MONTH_AGO = "month ago";
    private static final String WEEK_LATER = "week later";
    private static final String WEEK_AGO = "week ago";
    private static final String YEAR_LATER = "year later";
    private static final String YEAR_AGO = "year ago";

    private static final Pattern TIME_AGO = Pattern.compile("\\d+ (day(s)?|week(s)?|month(s)?|year(s)?) ago");
    private static final Pattern COMING_SOON =
        Pattern.compile("(tomorrow|today|yesterday|day before yesterday|after tomorrow)");
    private static final Pattern TIME_LATER = Pattern.compile("\\d+ (day(s)?|week(s)?|month(s)?|year(s)?) later");

    @Override
    public Optional<LocalDate> parseDate(String input) {
        LocalDate time = null;
        if (TIME_AGO.matcher(input).matches()) {
            time = getAgoTime(input);
        } else if (COMING_SOON.matcher(input).matches()) {
            time = getComingSoon(input);
        } else if (TIME_LATER.matcher(input).matches()) {
            time = getLaterTime(input);
        }

        if (time != null) {
            return Optional.of(time);
        }
        if (this.getNextStrongDateFormat() != null) {
            return getNextStrongDateFormat().parseDate(input);
        }
        return Optional.empty();
    }

    private LocalDate getLaterTime(String input) {
        String[] parseInput = input.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parseInput[1]);
        stringBuilder.append(" ");
        stringBuilder.append(parseInput[2]);
        var count = Integer.getInteger(parseInput[0]);

        return switch (stringBuilder.toString()) {
            case WEEK_LATER, WEEKS_LATER -> LocalDate.now().plusWeeks(count);
            case MONTHS_LATER, MONTH_LATER -> LocalDate.now().plusMonths(count);
            case YEAR_LATER, YEARS_LATER -> LocalDate.now().plusYears(count);
            case DAY_LATER, DAYS_LATER -> LocalDate.now().plusDays(count);
            default -> null;
        };
    }

    private LocalDate getComingSoon(String input) {
        return switch (input) {
            case TOMORROW -> LocalDate.now().plusDays(1);
            case TODAY -> LocalDate.now();
            case YESTERDAY -> LocalDate.now().minusDays(1);
            default -> null;
        };
    }

    private LocalDate getAgoTime(String input) {
        String[] parseInput = input.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(parseInput[1]);
        stringBuilder.append(" ");
        stringBuilder.append(parseInput[2]);
        var count = Integer.getInteger(parseInput[0]);

        return switch (stringBuilder.toString()) {
            case WEEK_AGO, WEEKS_AGO -> LocalDate.now().minusWeeks(count);
            case MONTHS_AGO, MONTH_AGO -> LocalDate.now().minusMonths(count);
            case YEAR_AGO, YEARS_AGO -> LocalDate.now().minusYears(count);
            case DAY_AGO, DAYS_AGO -> LocalDate.now().minusDays(count);
            default -> null;
        };
    }
}
