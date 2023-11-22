package edu.hw7.Task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicePersonDatabase implements PersonDatabase {
    private static volatile Map<Integer, Person> personCache = new HashMap<>();

    @Override
    public void add(Person person) {
        synchronized (personCache) {
            personCache.put(person.id(), person);
        }
    }

    @Override
    public void delete(int id) {
        synchronized (personCache) {
            personCache.remove(id);
        }
    }

    @Override
    public List<Person> findByName(String name) {
        synchronized (personCache) {
            return personCache.values().stream()
                .filter(person -> person.name().equals(name) && person.phoneNumber() != null
                    && person.address() != null).toList();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        synchronized (personCache) {
            return personCache.values().stream()
                .filter(person -> person.address().equals(address) && person.phoneNumber() != null
                    && person.name() != null).toList();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        synchronized (personCache) {
            return personCache.values().stream()
                .filter(person -> person.phoneNumber().equals(phone) && person.name() != null
                    && person.address() != null).toList();
        }
    }
}
