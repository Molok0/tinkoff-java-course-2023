package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    void sortedAnimal(){
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("a", Animal.Type.CAT, Animal.Sex.F, 25,4,100, false));
        animals.add(new Animal("b", Animal.Type.CAT, Animal.Sex.F, 25,3,100, false));
        animals.add(new Animal("c", Animal.Type.CAT, Animal.Sex.F, 25,2,100, false));
        animals.add(new Animal("d", Animal.Type.CAT, Animal.Sex.F, 25,1,100, false));


        List<Animal> sortAnimals = new ArrayList<>();
        sortAnimals.add(new Animal("d", Animal.Type.CAT, Animal.Sex.F, 25,1,100, false));
        sortAnimals.add(new Animal("c", Animal.Type.CAT, Animal.Sex.F, 25,2,100, false));
        sortAnimals.add(new Animal("b", Animal.Type.CAT, Animal.Sex.F, 25,3,100, false));
        sortAnimals.add(new Animal("a", Animal.Type.CAT, Animal.Sex.F, 25,4,100, false));

        assertThat(Tasks.sortedAnimalToHeight(animals)).isEqualTo(sortAnimals);
    }
}
