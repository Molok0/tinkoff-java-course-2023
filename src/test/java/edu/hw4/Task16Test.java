package edu.hw4;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task16Test {
    @Test
    void sortedAnimalTo(){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("a", Animal.Type.CAT, Animal.Sex.F, 2, 4, 1, false));
        animals.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 3, 2, 2, false));
        animals.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 4, 2, 54, false));
        animals.add(new Animal("c", Animal.Type.BIRD, Animal.Sex.F, 4, 3, 3, false));
        animals.add(new Animal("dfff", Animal.Type.CAT, Animal.Sex.F, 3, 1, 4, false));

        List<Animal> sortedAnimalList = Arrays.asList(
            new Animal("a", Animal.Type.CAT, Animal.Sex.F, 2, 4, 1, false),
            new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 3, 2, 2, false),
            new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 4, 2, 54, false),
            new Animal("c", Animal.Type.BIRD, Animal.Sex.F, 4, 3, 3, false),
            new Animal("dfff", Animal.Type.CAT, Animal.Sex.F, 3, 1, 4, false)
        );
        assertThat(Tasks.sortedAnimalTo(animals)).isEqualTo(sortedAnimalList);
    }
}
