package edu.hw4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task9 {
    public static Integer getCountFoot(List<Animal> animals){
        return animals.stream().collect(Collectors.summingInt(Animal::paws)).intValue();
    }
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("a", Animal.Type.CAT, Animal.Sex.F, 25, 4, 1, false));
        animals.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 25, 2, 2, false));
        animals.add(new Animal("c", Animal.Type.BIRD, Animal.Sex.F, 25, 3, 3, false));
        animals.add(new Animal("dfff", Animal.Type.CAT, Animal.Sex.F, 25, 1, 4, false));
        Integer countPaws = getCountFoot(animals);
        System.out.println(countPaws);
    }

}
