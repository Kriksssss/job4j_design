package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkToList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("apple", "banana", "cherry", "date");
        assertThat(list).hasSize(4)
                .contains("apple")
                .contains("banana", Index.atIndex(1))
                .containsAnyOf("kiwi", "date", "apple")
                .doesNotContain("grape", Index.atIndex(1));
    }

    @Test
    void checkToSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("red", "green", "blue", "yellow");
        assertThat(set).hasSize(4)
                .contains("red")
                .containsAnyOf("white", "blue", "black")
                .doesNotContain("orange");
    }

    @Test
    void checkToMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("one", "two", "three", "four", "five");
        assertThat(map).hasSize(5)
                .containsEntry("one", 0)
                .containsKey("two")
                .containsKeys("four", "five")
                .doesNotContainKey("zero");
    }
}