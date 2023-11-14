package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    void lengthCheck() {
        assertThat(Task7.lengthCheck("010")).isEqualTo(true);
    }

    @Test
    void symbolBeginningEqualsEnd() {
        assertThat(Task7.symbolBeginningEqualsEnd("010")).isEqualTo(true);
    }

    @Test
    void leastThreeCharactersAndThirdIsZero() {
        assertThat(Task7.leastThreeCharactersAndThirdIsZero("010")).isEqualTo(true);
    }

    @Test
    void lengthCheckFalse() {
        assertThat(Task7.lengthCheck("0101")).isEqualTo(false);
    }

    @Test
    void symbolBeginningEqualsEndFalse() {
        assertThat(Task7.symbolBeginningEqualsEnd("011")).isEqualTo(false);
    }

    @Test
    void leastThreeCharactersAndThirdIsZeroFalse() {
        assertThat(Task7.leastThreeCharactersAndThirdIsZero("0000")).isEqualTo(false);
    }
}
