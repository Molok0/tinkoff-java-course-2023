package edu.hw7;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task1Test {

    @Test
    void incrementTest1() {
        assertThat(Task1.increment(50)).isEqualTo(110);
    }

    @Test
    void incrementTest2() {
        assertThat(Task1.increment(0)).isEqualTo(60);
    }
}
