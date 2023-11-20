package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {

    @Test
    void isPalindromeDescendantTest1() {
        assertThat(Task5.isPalindromeDescendant(11211230)).isEqualTo(true);
    }

    @Test
    void isPalindromeDescendantTest2() {
        assertThat(Task5.isPalindromeDescendant(13001120)).isEqualTo(true);
    }

    @Test
    void isPalindromeDescendantTest4() {
        assertThat(Task5.isPalindromeDescendant(23336014)).isEqualTo(true);
    }

    @Test
    void isPalindromeDescendantTwoIdenticalNumbers() {
        assertThat(Task5.isPalindromeDescendant(11)).isEqualTo(true);
    }

    @Test
    void isPalindromeOneDigit() {
        assertThat(Task5.isPalindromeDescendant(1)).isEqualTo(false);
    }

    @Test
    void isPalindromeFalseTest() {
        assertThat(Task5.isPalindromeDescendant(1234)).isEqualTo(false);
    }
}
