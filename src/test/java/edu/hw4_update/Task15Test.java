package edu.hw4_update;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task15Test {
    @Test
    void allAnimalsEveryKind(){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("a", Animal.Type.CAT, Animal.Sex.F, 2, 4, 1, false));
        animals.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 3, 2, 2, false));
        animals.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 4, 2, 54, false));
        animals.add(new Animal("c", Animal.Type.BIRD, Animal.Sex.F, 4, 3, 3, false));
        animals.add(new Animal("dfff", Animal.Type.CAT, Animal.Sex.F, 3, 1, 4, false));

        Map<Animal.Type, Integer> countPaws = new HashMap<>();
        countPaws.put(Animal.Type.DOG,56);
        countPaws.put(Animal.Type.CAT,5);
        countPaws.put(Animal.Type.BIRD,3);
        assertThat(Tasks.allAnimalsEveryKind(animals,1,5)).isEqualTo(countPaws);
    }
}
