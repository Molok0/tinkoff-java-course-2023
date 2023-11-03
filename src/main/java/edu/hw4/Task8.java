package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Task8 {
    public static Optional<Animal> heaviestAnimal(List<Animal> animals, int k) {
        return animals.stream().filter(animal -> animal.height() < k)
            .sorted(Comparator.comparing(Animal::weight).reversed()).findFirst();
    }
}
