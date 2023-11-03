package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task7 {
    public static Animal oldestAnimal(List<Animal> animals, int k){
        return animals.stream().sorted(Comparator.comparing(Animal::age).reversed()).collect(Collectors.toList()).get(k-1);
    }
}
