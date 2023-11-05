package edu.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task3 {
    public static <T> HashMap<T, Integer> freqDict(List<T> words) {
        HashMap<T, Integer> answer = new HashMap<>();
        for (var word : words) {
            if (answer.containsKey(word)) {
                answer.put(word, answer.get(word) + 1);
            } else {
                answer.put(word, 1);
            }
        }
        return answer;
    }
}
