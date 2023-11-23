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
    @Test
    void incrementTest3() {
        assertThat(Task1.increment(-60)).isEqualTo(0);
    }

    @Test
    void incrementTes4() {
        assertThat(Task1.increment(10000)).isEqualTo(10060);
    }
    @Test
    void incrementTes5() {
        assertThat(Task1.increment(-10000)).isEqualTo(-9940);
    }
}
