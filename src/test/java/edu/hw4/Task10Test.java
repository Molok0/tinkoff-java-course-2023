package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task10Test {
    @Test
    void ageNotEqualPaws() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("a", Animal.Type.CAT, Animal.Sex.F, 4, 31, 9, false));
        animals.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 6, 2, 11, false));
        animals.add(new Animal("c", Animal.Type.BIRD, Animal.Sex.F, 2, 15, 5, false));
        animals.add(new Animal("dfff", Animal.Type.CAT, Animal.Sex.F, 11, 8, 24, false));

        List<Animal> answer = new ArrayList<>();
        answer.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 6, 2, 11, false));
        answer.add(new Animal("dfff", Animal.Type.CAT, Animal.Sex.F, 11, 8, 24, false));
        assertThat(Tasks.ageNotEqualPaws(animals)).isEqualTo(answer);
    }
}
