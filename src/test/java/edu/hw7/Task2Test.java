package edu.hw7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void getMultithreadingFactorialTest1() {
        assertThat(Task2.getMultithreadingFactorial(10)).isEqualTo(3628800L);
    }
    @Test
    void getMultithreadingFactorialTest2() {
        assertThat(Task2.getMultithreadingFactorial(1)).isEqualTo(1);
    }
    @Test
    void getMultithreadingFactorialTest3() {
        assertThat(Task2.getMultithreadingFactorial(5)).isEqualTo(120);
    }
}
