package edu.hw4;

import java.util.ArrayList;
import java.util.List;

public class Task13 {
    public static List<Animal> a(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name().split(" ").length >= 2).toList();
    }
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("a", Animal.Type.CAT, Animal.Sex.F, 25, 4, 1, false));
        animals.add(new Animal("b boba a", Animal.Type.CAT, Animal.Sex.F, 25, 2, 2, false));
        animals.add(new Animal("c", Animal.Type.CAT, Animal.Sex.F, 25, 3, 3, false));
        animals.add(new Animal("d l", Animal.Type.CAT, Animal.Sex.F, 25, 1, 4, false));
        List<Animal> sortAnimal = a(animals);
        sortAnimal.stream().forEach(System.out::println);
    }
}
