package edu.hw4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task15 {
    public static Map<Animal.Type, Integer> a(List<Animal> animals, int k, int l) {
        return animals.stream()
            .filter(animal -> animal.age() > k && animal.age() < l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("a", Animal.Type.CAT, Animal.Sex.F, 2, 4, 1, false));
        animals.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 3, 2, 2, false));
        animals.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 4, 2, 54, false));
        animals.add(new Animal("c", Animal.Type.BIRD, Animal.Sex.F, 4, 3, 3, false));
        animals.add(new Animal("dfff", Animal.Type.CAT, Animal.Sex.F, 3, 1, 4, false));
        Map<Animal.Type, Integer> countPaws = a(animals, 1 ,5 );
        countPaws.entrySet().stream().forEach(typeAnimalEntry -> System.out.println(typeAnimalEntry));
    }
}
