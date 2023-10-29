package edu.hw3;

import java.util.Comparator;

public class Task7<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if (o1 == o2)
            return 0;
        else if (o1 == null)
            return 1;
        else if (o2 == null)
            return -1;
        return 0;
    }
}
