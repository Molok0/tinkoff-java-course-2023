package edu.hw4_update;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task11Test {
    @Test
    void animalsThatCanBite(){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("a", Animal.Type.CAT, Animal.Sex.F, 25, 31, 9, false));
        animals.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 25, 110, 11, true));
        animals.add(new Animal("c", Animal.Type.BIRD, Animal.Sex.F, 25, 15, 5, true));
        animals.add(new Animal("dfff", Animal.Type.CAT, Animal.Sex.F, 25, 143, 24, true));

        List<Animal> biteAnimals = new ArrayList<>();
        biteAnimals.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 25, 110, 11, true));
        biteAnimals.add(new Animal("dfff", Animal.Type.CAT, Animal.Sex.F, 25, 143, 24, true));

        assertThat(Tasks.animalsThatCanBite(animals)).isEqualTo(biteAnimals);
    }
}
