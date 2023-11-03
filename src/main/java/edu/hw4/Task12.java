package edu.hw4;

import java.util.List;

public class Task12 {
    public static Integer a(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.height() < animal.weight()).toList().size();
    }
}
