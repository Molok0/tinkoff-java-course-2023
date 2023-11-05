package edu.hw4_update;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public final class Tasks {

    private static final int NECESSARY_GROWTH = 100;

    private Tasks() {}

    public static List<Animal> sortedAnimalToHeight(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparing(Animal::height)).collect(Collectors.toList());
    }

    public static List<Animal> sortedAnimalToWright(List<Animal> animals, int k) {
        return animals.stream().sorted(Comparator.comparing(Animal::weight).reversed()).limit(k)
            .collect(Collectors.toList());
    }

    public static Map<Animal.Type, Integer> getAnimalsCount(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(animal -> animal.type(), Collectors.summingInt(animal -> 1)))
            .entrySet().stream().collect(Collectors.toMap(entry -> entry.getKey(), Map.Entry::getValue));
    }

    public static Animal getLongestName(List<Animal> animals) {
        return animals.stream().collect(Collectors.maxBy(Comparator.comparing(animal -> animal.name().length()))).get();
    }

    public static Animal.Sex getSex(List<Animal> animals) {
        return animals.stream().collect(Collectors.groupingBy(Animal::sex, Collectors.counting()))
            .entrySet().stream()
            .max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey)
            .orElse(null);
    }

    public static Map<Animal.Type, Animal> heaviestAnimalEachSpecies(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.maxBy(Comparator.comparingInt(Animal::weight))))
            .entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().orElse(null)));
    }

    public static Animal oldestAnimal(List<Animal> animals, int k) {
        return animals.stream().sorted(Comparator.comparing(Animal::age).reversed()).collect(Collectors.toList())
            .get(k - 1);
    }

    public static Optional<Animal> heaviestAnimal(List<Animal> animals, int k) {
        return animals.stream().filter(animal -> animal.height() < k)
            .sorted(Comparator.comparing(Animal::weight).reversed()).findFirst();
    }

    public static Integer getCountFoot(List<Animal> animals) {
        return animals.stream().collect(Collectors.summingInt(Animal::paws)).intValue();
    }

    public static List<Animal> ageNotEqualPaws(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.age() != animal.paws()).toList();
    }

    public static List<Animal> animalsThatCanBite(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.height() > NECESSARY_GROWTH && animal.bites()).toList();
    }

    public static Integer weightGreaterThanHeight(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.height() < animal.weight()).toList().size();
    }

    public static List<Animal> animalsWithLongName(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name().split(" ").length >= 2).toList();
    }

    public static Boolean dogInList(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > k);
    }

    public static Map<Animal.Type, Integer> allAnimalsEveryKind(List<Animal> animals, int k, int l) {
        return animals.stream()
            .filter(animal -> animal.age() > k && animal.age() < l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    public static List<Animal> sortedAnimalTo(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparing(Animal::type)).sorted(Comparator.comparing(Animal::sex))
            .sorted(Comparator.comparing(Animal::name)).toList();
    }

    public static Boolean check(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG || animal.type() == Animal.Type.SPIDER)
            .anyMatch(animal -> animal.type() == Animal.Type.SPIDER && animal.bites());
    }

    public static Animal heaviestFish(List<List<Animal>> animals) {
        return animals.stream().flatMap(List::stream).filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight)).orElse(null);
    }

    public static Map<String, Set<ValidationError>> getErrorAnimal(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(
                Animal::name,
                Collectors.flatMapping(animal -> checkCorrectAnimal(animal).stream(), Collectors.toSet())
            ));
    }

    private static Set<ValidationError> checkCorrectAnimal(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();
        if (animal.age() < 0) {
            errors.add(ValidationError.INVALID_AGE);
        }
        if (animal.height() < 0) {
            errors.add(ValidationError.INVALID_HEIGHT);
        }
        if (animal.weight() < 0) {
            errors.add(ValidationError.INVALID_WEIGHT);
        }
        return errors;
    }
}
