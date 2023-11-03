package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task10 {
    public static List<Animal> ageNotEqualPaws(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.age() != animal.paws()).toList();
    }
}
