package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    @Test
    void freqDict1() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("bb");
        list.add("a");
        list.add("bb");
        HashMap<String, Integer> answer = new HashMap<>();
        answer.put("bb", 2);
        answer.put("a", 2);
        assertThat(Task3.freqDict(list)).isEqualTo(answer);
    }

    @Test
    void freqDict2() {
        List<String> list = new ArrayList<>();
        list.add("this");
        list.add("and");
        list.add("that");
        list.add("and");
        HashMap<String, Integer> answer = new HashMap<>();
        answer.put("that", 1);
        answer.put("and", 2);
        answer.put("this", 1);
        assertThat(Task3.freqDict(list)).isEqualTo(answer);
    }

    @Test
    void freqDict3() {
        List<String> list = new ArrayList<>();
        list.add("код");
        list.add("код");
        list.add("код");
        list.add("bug");
        HashMap<String, Integer> answer = new HashMap<>();
        answer.put("код", 3);
        answer.put("bug", 1);
        assertThat(Task3.freqDict(list)).isEqualTo(answer);
    }

    @Test
    void freqDict4() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        HashMap<Integer, Integer> answer = new HashMap<>();
        answer.put(1, 2);
        answer.put(2, 2);
        assertThat(Task3.freqDict(list)).isEqualTo(answer);
    }
}
