package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    void checkPassword1() {
        assertThat(Task4.checkPassword("Passwo~rd")).isEqualTo(true);
    }
    @Test
    void checkPasswordFalse() {
        assertThat(Task4.checkPassword("Password")).isEqualTo(false);
    }

    @Test
    void checkPassword2() {
        assertThat(Task4.checkPassword("~ ! @ # $ % ^ & * |")).isEqualTo(true);
    }
    @Test
    void checkPassword3() {
        assertThat(Task4.checkPassword("asdasd*")).isEqualTo(true);
    }
    @Test
    void checkPassword4() {
        assertThat(Task4.checkPassword("@")).isEqualTo(true);
    }
}
