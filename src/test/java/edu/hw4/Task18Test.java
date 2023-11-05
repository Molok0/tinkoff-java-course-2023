package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task18Test {
    @Test
    void heaviestFish(){
        List<Animal> animals1 = new ArrayList<>();
        animals1.add(new Animal("a", Animal.Type.FISH, Animal.Sex.F, 3, 3, 1, false));
        animals1.add(new Animal("ba", Animal.Type.DOG, Animal.Sex.F, 3, 2, 2, false));
        animals1.add(new Animal("ba", Animal.Type.SPIDER, Animal.Sex.F, 4, 2, 54, false));
        animals1.add(new Animal("c", Animal.Type.BIRD, Animal.Sex.F, 4, 3, 3, false));
        animals1.add(new Animal("dfff", Animal.Type.CAT, Animal.Sex.F, 3, 1, 4, false));

        List<Animal> animals2 = new ArrayList<>();
        animals1.add(new Animal("Кот", Animal.Type.CAT, Animal.Sex.M, 5, 40, 20, true));
        animals1.add(new Animal("Рыбка", Animal.Type.FISH, Animal.Sex.F, 1, 10, 6, false));
        animals1.add(new Animal("Олег", Animal.Type.FISH, Animal.Sex.M, 2, 13, 4, false));
        animals1.add(new Animal("Паук", Animal.Type.SPIDER, Animal.Sex.M, 1, 7, 3, false));
        animals1.add(new Animal("Второй кот", Animal.Type.CAT, Animal.Sex.F, 3, 1, 4, false));

        List<List<Animal>> listAnimals = new ArrayList<>();
        listAnimals.add(animals1);
        listAnimals.add(animals2);

        assertThat(Tasks.heaviestFish(listAnimals)).isEqualTo(new Animal("Рыбка", Animal.Type.FISH, Animal.Sex.F, 1, 10, 6, false));
    }
}
