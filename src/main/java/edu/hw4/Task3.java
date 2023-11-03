package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task3 {
    public static Map<Animal.Type, Integer> getAnimalsCount(List<Animal> animals) {
        Map<Animal.Type, Integer> answer = new HashMap<>();
        animals.stream().forEach(x -> answer.put(x.type(), answer.getOrDefault(x.type(), 0) + 1));
        return answer;
    }
}
