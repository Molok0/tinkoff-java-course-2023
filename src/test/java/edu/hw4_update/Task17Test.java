package edu.hw4_update;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task17Test {
    @Test
    void check(){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("a", Animal.Type.SPIDER, Animal.Sex.F, 2, 4, 1, true));
        animals.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 3, 2, 2, true));
        animals.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 4, 2, 54, false));
        animals.add(new Animal("c", Animal.Type.SPIDER, Animal.Sex.F, 4, 3, 3, true));
        animals.add(new Animal("dfff", Animal.Type.SPIDER, Animal.Sex.F, 3, 1, 4, false));

        assertThat(Tasks.check(animals)).isEqualTo(true);
    }
}
