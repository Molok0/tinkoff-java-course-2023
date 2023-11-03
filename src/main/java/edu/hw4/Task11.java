package edu.hw4;

import java.util.List;

public class Task11 {
    public static List<Animal> a(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.height() > 100 && animal.bites() == true).toList();
    }
}
