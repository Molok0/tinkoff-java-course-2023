package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task5 {
    public static Animal.Sex getSex(List<Animal> animals){
        return animals.stream().collect(Collectors.groupingBy(Animal::sex, Collectors.counting()))
            .entrySet().stream()
            .max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey)
            .orElse(null);
    }
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("a", Animal.Type.CAT, Animal.Sex.M, 25, 4, 1, false));
        animals.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.M, 25, 2, 2, false));
        animals.add(new Animal("c", Animal.Type.BIRD, Animal.Sex.F, 25, 3, 3, false));
        animals.add(new Animal("dfff", Animal.Type.CAT, Animal.Sex.F, 25, 1, 4, false));
        Animal.Sex sex = getSex(animals);
        System.out.println(sex);
    }
}
