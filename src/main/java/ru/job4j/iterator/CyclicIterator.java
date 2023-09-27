package ru.job4j.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CyclicIterator<T> implements Iterator<T> {

    private final List<T> data;
    private int currentIndex;

    public CyclicIterator(List<T> data) {
        this.data = data;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return !data.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T element = data.get(currentIndex);
        currentIndex = (currentIndex + 1) % data.size();
        return element;
    }
}