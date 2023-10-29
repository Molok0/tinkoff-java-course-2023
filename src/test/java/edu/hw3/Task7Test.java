package edu.hw3;

import org.junit.jupiter.api.Test;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    void nullComparator(){
        var a = new Task7();
        TreeMap<String, String> tree = new TreeMap<>(a);
        tree.put(null, "test");

        assertThat(tree.containsKey(null)).isTrue();
    }
}
