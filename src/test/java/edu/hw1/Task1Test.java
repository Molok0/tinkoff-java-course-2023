package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    void minutesToSeconds() {
        ArrayList<Long> expected = new ArrayList<>();
        ArrayList<Long> answers = new ArrayList<>();

        expected.add(60L);
        expected.add(836L);
        expected.add(-1L);
        expected.add(59999L);

        answers.add(Task1.minutesToSeconds("01:00"));
        answers.add(Task1.minutesToSeconds("13:56"));
        answers.add(Task1.minutesToSeconds("10:60"));
        answers.add(Task1.minutesToSeconds("999:59"));

        assertEquals(expected, answers);

    }
}
