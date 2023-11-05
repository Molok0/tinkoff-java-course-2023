package edu.hw4_update;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task14Test {
    @Test
    void dogInList(){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("a", Animal.Type.CAT, Animal.Sex.F, 25, 4, 1, false));
        animals.add(new Animal("b boba a", Animal.Type.CAT, Animal.Sex.F, 25, 2, 2, false));
        animals.add(new Animal("c", Animal.Type.DOG, Animal.Sex.F, 25, 31, 3, false));
        animals.add(new Animal("d l", Animal.Type.DOG, Animal.Sex.F, 25, 24, 4, false));

        assertThat(Tasks.dogInList(animals, 30)).isEqualTo(true);
    }
}
