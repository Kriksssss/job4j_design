package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConfigTest {

    private Config config;

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenFileWithCommentsAndEmptyLines() {
        String path = "./data/file_with_comments.properties";
        config = new Config(path);
        config.load();
        assertThat(config.value("key1")).isEqualTo("value1");
        assertThat(config.value("key2")).isEqualTo("value2");
    }

    @Test
    void whenInvalidFormatFile() {
        String path = "./data/file_with_invalid_format.properties";
        config = new Config(path);
        assertThrows(IllegalArgumentException.class, () -> config.load());
    }

    @Test
    void whenEmptyValue() {
        String path = "./data/file_with_empty_value.properties";
        config = new Config(path);
        assertThrows(IllegalArgumentException.class, () -> config.load());
    }
}
