package edu.hw4_update;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task13Test {
    @Test
    void animalsWithLongName(){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("a", Animal.Type.CAT, Animal.Sex.F, 25, 4, 1, false));
        animals.add(new Animal("b boba a", Animal.Type.CAT, Animal.Sex.F, 25, 2, 2, false));
        animals.add(new Animal("c", Animal.Type.CAT, Animal.Sex.F, 25, 3, 3, false));
        animals.add(new Animal("d l", Animal.Type.CAT, Animal.Sex.F, 25, 1, 4, false));

        List<Animal> longNameAnimal = new ArrayList<>();
        longNameAnimal.add(new Animal("b boba a", Animal.Type.CAT, Animal.Sex.F, 25, 2, 2, false));
        longNameAnimal.add(new Animal("d l", Animal.Type.CAT, Animal.Sex.F, 25, 1, 4, false));
        assertThat(Tasks.animalsWithLongName(animals)).isEqualTo(longNameAnimal);
    }
}
