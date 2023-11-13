package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    void leastThreeCharactersAndThirdIsZero(){
        assertThat(Task7.lengthCheck("010")).isEqualTo(true);
    }

    @Test
    void symbolBeginningEqualsEnd(){
        assertThat(Task7.symbolBeginningEqualsEnd("010")).isEqualTo(true);
    }
    @Test
    void lengthCheck(){
        assertThat(Task7.leastThreeCharactersAndThirdIsZero("0010")).isEqualTo(true);
    }
}
