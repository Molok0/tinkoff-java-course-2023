package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    void rotateLeft1() {
        assertThat(Task7.rotateLeft(17, 2)).isEqualTo(6);
    }

    @Test
    void rotateLeft2() {
        assertThat(Task7.rotateLeft(16, 1)).isEqualTo(1);
    }

    @Test
    void rotateRight() {
        assertThat(Task7.rotateRight(8, 1)).isEqualTo(4);
    }

    @Test
    void rotateRightZero() {
        assertThat(Task7.rotateRight(8, 0)).isEqualTo(8);
    }

    @Test
    void rotateLeft() {
        assertThat(Task7.rotateLeft(3, 3)).isEqualTo(3);
    }
}
