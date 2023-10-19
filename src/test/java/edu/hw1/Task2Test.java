package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @Test
    void countDigits() {
        assertThat(Task2.countDigits(1023)).isEqualTo(4);
    }

    @Test
    void countDigitsNegativeNumber() {
        assertThat(Task2.countDigits(-1)).isEqualTo(1);
    }

    @Test
    void countDigitsStartsFromZero() {
        int number = 00000001;
        assertThat(Task2.countDigits(number)).isEqualTo(1);
    }

    @Test
    void countDigitsZero() {
        int number = 0;
        assertThat(Task2.countDigits(number)).isEqualTo(1);
    }

}
