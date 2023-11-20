package edu.hw1;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {

    @Test
    void isNestableTrue() {
        int[] a = new int[] {1, 2, 3, 4};
        int[] b = new int[] {0, 6};

        assertThat(Task3.isNestable(a, b)).isEqualTo(true);
    }

    @Test
    void isNestableFalse() {
        int[] a = new int[] {9, 9, 8};
        int[] b = new int[] {8, 9};

        assertThat(Task3.isNestable(a, b)).isEqualTo(false);
    }

    @Test
    void isNestableArrayEmpty() {
        int[] a = new int[] {};
        int[] b = new int[] {};

        assertThat(Task3.isNestable(a, b)).isEqualTo(false);
    }

    @Test
    void isNestableIdenticalArrays() {
        int[] a = new int[] {9, 9};
        int[] b = new int[] {9, 9};

        assertThat(Task3.isNestable(a, b)).isEqualTo(false);
    }

    @Test
    void isNestableMoreFalseTest() {
        int[] a = new int[] {1, 2, 3, 4};
        int[] b = new int[] {2, 3};

        assertThat(Task3.isNestable(a, b)).isEqualTo(false);
    }

}
