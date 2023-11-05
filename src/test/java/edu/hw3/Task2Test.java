package edu.hw3;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void clusterize1() {
        assertThat(Task2.clusterize("()()()"));
    }

    @Test
    void clusterize2() {
        assertThat(Task2.clusterize("((()))"));
    }

    @Test
    void clusterize3() {
        assertThat(Task2.clusterize("((()))(())()()(()())"));
    }

    @Test
    void clusterize4() {
        assertThat(Task2.clusterize("((())())(()(()()))"));
    }
}
