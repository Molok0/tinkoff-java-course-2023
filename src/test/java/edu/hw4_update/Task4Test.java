package edu.hw4_update;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    void getLongestName() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("a", Animal.Type.CAT, Animal.Sex.F, 25, 4, 1, false));
        animals.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 25, 2, 2, false));
        animals.add(new Animal("c", Animal.Type.BIRD, Animal.Sex.F, 25, 3, 3, false));
        animals.add(new Animal("dfff", Animal.Type.CAT, Animal.Sex.F, 25, 1, 4, false));

        assertThat(Tasks.getLongestName(animals)).isEqualTo(new Animal("dfff", Animal.Type.CAT, Animal.Sex.F, 25, 1, 4, false));
    }
}
