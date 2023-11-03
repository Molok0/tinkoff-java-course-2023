package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void sortedAnimalToWright() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("a", Animal.Type.CAT, Animal.Sex.F, 25, 4, 1, false));
        animals.add(new Animal("b", Animal.Type.CAT, Animal.Sex.F, 25, 2, 2, false));
        animals.add(new Animal("c", Animal.Type.CAT, Animal.Sex.F, 25, 3, 3, false));
        animals.add(new Animal("d", Animal.Type.CAT, Animal.Sex.F, 25, 1, 4, false));

        List<Animal> sortAnimals = new ArrayList<>();
        sortAnimals.add(new Animal("d", Animal.Type.CAT, Animal.Sex.F, 25, 1, 4, false));
        sortAnimals.add(new Animal("c", Animal.Type.CAT, Animal.Sex.F, 25, 3, 3, false));
        sortAnimals.add(new Animal("b", Animal.Type.CAT, Animal.Sex.F, 25, 2, 2, false));

        assertThat(Task2.sortedAnimalToWright(animals, 3)).isEqualTo(sortAnimals);
    }
}
