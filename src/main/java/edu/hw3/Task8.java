package edu.hw3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task8<E> implements Iterator<E> {
    private List<E> collect;
    private int sizeCollect;

    public Task8(List<E> collect) {
        this.collect = collect;
        this.sizeCollect = collect.size();
    }

    @Override
    public boolean hasNext() {
        return sizeCollect > -1;
    }

    @Override
    public E next() {
        return collect.get(sizeCollect--);
    }
}
