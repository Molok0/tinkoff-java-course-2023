package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public static List<Animal> sortedAnimalToHeight(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparing(Animal::height)).collect(Collectors.toList());
    }

}
