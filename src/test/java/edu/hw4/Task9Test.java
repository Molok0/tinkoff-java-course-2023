package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task9Test {
    @Test
    void getCountFoot(){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("a", Animal.Type.CAT, Animal.Sex.F, 25, 31, 9, false));
        animals.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 25, 2, 11, false));
        animals.add(new Animal("c", Animal.Type.BIRD, Animal.Sex.F, 25, 15, 5, false));
        animals.add(new Animal("dfff", Animal.Type.CAT, Animal.Sex.F, 25, 8, 24, false));

        assertThat(Tasks.getCountFoot(animals)).isEqualTo(new Integer(14));
    }
}
