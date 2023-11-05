package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    void convertToRoman1() {
        assertThat(Task4.convertToRoman(2)).isEqualTo("II");
    }

    @Test
    void convertToRoman2() {
        assertThat(Task4.convertToRoman(12)).isEqualTo("XII");
    }

    @Test
    void convertToRoman3() {
        assertThat(Task4.convertToRoman(16)).isEqualTo("XVI");
    }

    @Test
    void convertToRoman4() {
        assertThat(Task4.convertToRoman(100)).isEqualTo("C");
    }

    @Test
    void convertToRoman5() {
        assertThat(Task4.convertToRoman(9999)).isEqualTo("MMMMMMMMMCMXCIX");
    }
}
