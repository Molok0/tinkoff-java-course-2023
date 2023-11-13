package edu.hw5;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    void getAllFridays1() {
        assertThat(Task2.getAllFridays(1925)).isEqualTo(List.of("1925-02-13", "1925-03-13", "1925-11-13"));
    }

    @Test
    void getNextFridays() {
        assertThat(Task2.getNextFridays(LocalDate.of(2024, 9, 13))).isEqualTo("2024-12-13");
    }

    @Test
    void getAllFridays2() {
        assertThat(Task2.getAllFridays(2024)).isEqualTo(List.of("2024-09-13", "2024-12-13"));
    }
}
