package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    void getAnimalsCount() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("a", Animal.Type.CAT, Animal.Sex.F, 25, 4, 1, false));
        animals.add(new Animal("b", Animal.Type.DOG, Animal.Sex.F, 25, 2, 2, false));
        animals.add(new Animal("c", Animal.Type.BIRD, Animal.Sex.F, 25, 3, 3, false));
        animals.add(new Animal("d", Animal.Type.CAT, Animal.Sex.F, 25, 1, 4, false));

        Map<Animal.Type, Integer> countAnimals = new HashMap<>();
        countAnimals.put(Animal.Type.CAT,2);
        countAnimals.put(Animal.Type.BIRD,1);
        countAnimals.put(Animal.Type.DOG,1);

        assertThat(Tasks.getAnimalsCount(animals)).isEqualTo(countAnimals);
    }
}
