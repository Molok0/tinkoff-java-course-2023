package edu.hw4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task19Test {

    @Test
    void getErrorAnimal() {
        List<Animal> animals = Arrays.asList(
            new Animal("кошка", Animal.Type.CAT, Animal.Sex.F, 3, -1, 3, false),
            new Animal("собака", Animal.Type.DOG, Animal.Sex.M, 4, 60, 30, false),
            new Animal("птица", Animal.Type.BIRD, Animal.Sex.F, 2, 10, -1, false),
            new Animal("рыба", Animal.Type.FISH, Animal.Sex.M, -1, 5, 0, false),
            new Animal("вторая кошка", Animal.Type.CAT, Animal.Sex.M, 1, 2, 1, false),
            new Animal("паук", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 0, true)
        );
        Map<String, Set<ValidationError>> answer = new HashMap<>();
        answer.put("рыба", Set.of(ValidationError.INVALID_AGE));
        answer.put("паук", new HashSet<>());
        answer.put("вторая кошка", new HashSet<>());
        answer.put("кошка", Set.of(ValidationError.INVALID_HEIGHT));
        answer.put("птица", Set.of(ValidationError.INVALID_WEIGHT));
        answer.put("собака", new HashSet<>());

        assertThat(Tasks.getErrorAnimal(animals)).isEqualTo(answer);
    }
}
