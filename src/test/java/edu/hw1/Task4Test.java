package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {

    @Test
    void fixStringNumbers() {
        assertThat(Task4.fixString("214365")).isEqualTo("123456");
    }

    @Test
    void fixString1() {
        assertThat(Task4.fixString("hTsii  s aimex dpus rtni.g")).isEqualTo("This is a mixed up string.");
    }

    @Test
    void fixStringIsEmpty() {
        assertThat(Task4.fixString("")).isEqualTo("");
    }

    @Test
    void fixString2() {
        assertThat(Task4.fixString("badce")).isEqualTo("abcde");
    }

    @Test
    void fixStringLen2() {
        assertThat(Task4.fixString("ab")).isEqualTo("ba");
    }

}
