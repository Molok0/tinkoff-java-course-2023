package edu.hw7.Task3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockPersonDatabase implements PersonDatabase {
    private static volatile Map<Integer, Person> personCache = new HashMap<>();
    private static ReadWriteLock lock = new ReentrantReadWriteLock();

    public int getSize() {
        lock.writeLock().lock();
        try {
            return personCache.size();
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        try {
            personCache.put(person.id(), person);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.readLock().lock();
        try {
            personCache.remove(id);
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByName(String name) {
        lock.readLock().lock();
        try {
            return personCache.values().stream()
                .filter(person -> person.name().equals(name) && person.phoneNumber() != null
                    && person.address() != null).toList();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        lock.readLock().lock();
        try {
            return personCache.values().stream()
                .filter(person -> person.address().equals(address) && person.phoneNumber() != null
                    && person.name() != null).toList();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        lock.readLock().lock();
        try {
            return personCache.values().stream()
                .filter(person -> person.phoneNumber().equals(phone) && person.name() != null
                    && person.address() != null).toList();
        } finally {
            lock.readLock().unlock();
        }
    }
}
