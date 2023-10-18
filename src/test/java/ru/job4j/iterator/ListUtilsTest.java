package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.function.Predicate;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        List<Integer> elements = Arrays.asList(2, 4, 6);
        ListUtils.removeAll(list, elements);
        List<Integer> expected = Arrays.asList(1, 3, 5, 7);
        assertEquals(expected, list);
    }

    @Test
    public void whenReplaceIf() {
        List<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
        Predicate<String> filter = s -> s.startsWith("b");
        String value = "blueberry";
        ListUtils.replaceIf(list, filter, value);
        List<String> expected = Arrays.asList("apple", "blueberry", "cherry");
        assertEquals(expected, list);
    }

    @Test
    public void whenRemoveIf() {
        List<String> list = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
        Predicate<String> filter = s -> s.startsWith("b");
        ListUtils.removeIf(list, filter);
        List<String> expected = Arrays.asList("apple", "cherry");
        assertEquals(expected, list);
    }
}
