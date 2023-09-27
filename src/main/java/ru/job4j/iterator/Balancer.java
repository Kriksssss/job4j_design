package ru.job4j.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс Balancer предоставляет статический метод split для равномерного разделения элементов из итератора по списку узлов.
 * Элементы распределяются между узлами в кольцевом порядке, начиная с первого узла и переходя к следующему после добавления элемента.
 */

public class Balancer {
    /**
     * Метод split разделяет элементы из итератора source по списку узлов nodes.
     * Элементы равномерно распределяются между коллекциями(узлами) в кольцевом порядке.
     *
     * @param nodes Список коллекций(узлов), в которые будут разделены элементы.
     * @param source      Итератор, из которого берутся элементы для разделения.
     */
    public static void split(List<ArrayList<Integer>> nodes, Iterator<Integer> source) {
        int index = 0;
        while (source.hasNext()) {
            nodes.get(index).add(source.next());
            index = (index + 1) % nodes.size();
        }
    }
}

