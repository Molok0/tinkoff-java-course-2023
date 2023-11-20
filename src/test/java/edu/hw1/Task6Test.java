package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {
    @Test
    void countK1() {
        assertThat(Task6.countK(6621)).isEqualTo(5);
    }

    @Test
    void countK2() {
        assertThat(Task6.countK(6554)).isEqualTo(4);
    }

    @Test
    void countK3() {
        assertThat(Task6.countK(1234)).isEqualTo(3);
    }

    @Test
    void countKforNumberK() {
        assertThat(Task6.countK(6174)).isEqualTo(0);
    }

    @Test
    void countKLeftBorder() {
        assertThat(Task6.countK(1001)).isEqualTo(4);
    }
}
