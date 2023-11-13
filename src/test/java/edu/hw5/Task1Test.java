package edu.hw5;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    void averageTimeSession() {
        String time1 = "2022-03-12, 20:20 - 2022-03-12, 23:50";
        String time2 = "2022-04-01, 21:30 - 2022-04-02, 01:20";

        assertThat(Task1.averageTimeSession(Arrays.asList(time1, time2))).isEqualTo("3ч 40м");
    }
}
