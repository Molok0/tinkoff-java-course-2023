package edu.hw5;

import edu.hw5.task3.Task3;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    void parseDateToday() {
        assertThat(Task3.parseDate("today")).isEqualTo(Optional.of(LocalDate.now()));
    }

    @Test
    void parseDateYesterday() {
        assertThat(Task3.parseDate("yesterday")).isEqualTo(Optional.of(LocalDate.now().minusDays(1)));
    }

    @Test
    void parseDateTomorrow() {
        assertThat(Task3.parseDate("tomorrow")).isEqualTo(Optional.of(LocalDate.now().plusDays(1)));
    }

    @Test
    void parseDateNonStandard1() {
        assertThat(Task3.parseDate("2020-12-2")).isEqualTo(Optional.of(LocalDate.of(2020, 12, 2)));
    }
}
