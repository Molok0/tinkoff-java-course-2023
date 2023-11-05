package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    void HeaviestAnimalEachSpecies() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("a", Animal.Type.CAT, Animal.Sex.F, 25, 4, 1, false));
        animals.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 25, 2, 2, false));
        animals.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 25, 2, 54, false));
        animals.add(new Animal("c", Animal.Type.BIRD, Animal.Sex.F, 25, 3, 3, false));
        animals.add(new Animal("dfff", Animal.Type.CAT, Animal.Sex.F, 25, 1, 4, false));

        Map<Animal.Type, Animal> typeAnimalMap = new HashMap<>();
        typeAnimalMap.put(Animal.Type.CAT, new Animal("dfff", Animal.Type.CAT, Animal.Sex.F, 25, 1, 4, false));
        typeAnimalMap.put(Animal.Type.DOG, new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 25, 2, 54, false));
        typeAnimalMap.put(Animal.Type.BIRD,new Animal("c", Animal.Type.BIRD, Animal.Sex.F, 25, 3, 3, false));
        assertThat(Tasks.HeaviestAnimalEachSpecies(animals)).isEqualTo(typeAnimalMap);
    }
}
