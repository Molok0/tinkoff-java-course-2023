package edu.hw4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static List<Animal> sortedAnimalToWright(List<Animal> animals, int k) {
        return animals.stream().sorted(Comparator.comparing(Animal::weight).reversed()).limit(k).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("a", Animal.Type.CAT, Animal.Sex.F, 25, 4, 1, false));
        animals.add(new Animal("b", Animal.Type.CAT, Animal.Sex.F, 25, 2, 2, false));
        animals.add(new Animal("c", Animal.Type.CAT, Animal.Sex.F, 25, 3, 3, false));
        animals.add(new Animal("d", Animal.Type.CAT, Animal.Sex.F, 25, 1, 4, false));
        List<Animal> sortAnimal = sortedAnimalToWright(animals, 3);
        sortAnimal.stream().forEach(System.out::println);
    }
}
