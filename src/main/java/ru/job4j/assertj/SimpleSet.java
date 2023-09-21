package ru.job4j.assertj;

import java.util.Arrays;
import java.util.Objects;

/**
 * Простая реализация множества (Set) на основе массива строк.
 */
public class SimpleSet {
    private String[] container = new String[2];
    private int size;

    /**
     * Добавляет указанное значение в множество.
     *
     * @param value значение, которое нужно добавить в множество.
     * @return true, если значение было успешно добавлено (если оно ранее не существовало в множестве), иначе false.
     */
    public boolean add(String value) {
        if (size == container.length) {
            grow();
        }
        boolean result = !contains(value);
        if (result) {
            container[size++] = value;
        }
        return result;
    }

    /**
     * Проверяет, содержит ли множество указанное значение.
     *
     * @param value значение, которое нужно проверить на наличие в множестве.
     * @return true, если значение уже существует в множестве, иначе false.
     */
    private boolean contains(String value) {
        boolean result = false;
        for (String element : container) {
            if (Objects.equals(value, element)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Увеличивает размер внутреннего массива, когда текущий массив заполняется.
     */
    private void grow() {
        container = Arrays.copyOf(container, container.length * 2);
    }
}

