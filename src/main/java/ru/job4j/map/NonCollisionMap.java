package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    private int hash(int hashCode) {
        return hashCode & (capacity - 1);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        int newCapacity = capacity * 2;
        MapEntry<K, V>[] newTable = new MapEntry[newCapacity];
        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                K key = entry.key;
                int hashCode = Objects.hashCode(key);
                int hash = hash(hashCode);
                int index = indexFor(hash);
                while (newTable[index] != null) {
                    index = (index + 1) & (newCapacity - 1);
                }
                newTable[index] = entry;
            }
        }
        capacity = newCapacity;
        table = newTable;
    }

    @Override
    public boolean put(K key, V value) {
        boolean inserted = false;
        int hashCode = Objects.hashCode(key);
        int hash = hash(hashCode);
        int index = indexFor(hash);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            if ((float) count / capacity >= LOAD_FACTOR) {
                expand();
            }
            inserted = true;
        }
        return inserted;
    }


    @Override
    public V get(K key) {
        V result = null;
        int hashCode = Objects.hashCode(key);
        int hash = hash(hashCode);
        int index = indexFor(hash);
        if (table[index] != null && Objects.equals(table[index].key, key)) {
            result = table[index].value;
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean removed = false;
        int hashCode = Objects.hashCode(key);
        int hash = hash(hashCode);
        int index = indexFor(hash);
        if (table[index] != null && Objects.equals(table[index].key, key)) {
            table[index] = null;
            count--;
            modCount++;
            removed = true;
        }
        return removed;
    }


    @Override
    public Iterator<K> iterator() {
        return new NonNullIterator();
    }

    private class NonNullIterator implements Iterator<K> {
        private int index;
        private final int expectModCount;

        public NonNullIterator() {
            this.index = 0;
            this.expectModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            if (expectModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            while (index < capacity && (table[index] == null)) {
                index++;
            }
            return index < capacity;
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return table[index++].key;
        }
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

