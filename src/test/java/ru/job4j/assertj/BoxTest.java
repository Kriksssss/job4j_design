package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void numberOfVerticesIsZero() {
        Box box = new Box(0, 10);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(0);
    }

    @Test
    void numberOfVerticesIsFour() {
        Box box = new Box(4, 10);
        int vertices = box.getNumberOfVertices();
        assertThat(vertices).isEqualTo(4);
    }

    @Test
    void doesNotExist() {
        Box box = new Box(-1, 10);
        boolean exists = box.isExist();
        assertThat(exists).isFalse();
    }

    @Test
    void exists() {
        Box box = new Box(4, 10);
        boolean exists = box.isExist();
        assertThat(exists).isTrue();
    }

    @Test
    void sphereArea() {
        Box box = new Box(0, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(1256.6370614359173);
    }

    @Test
    void tetrahedronArea() {
        Box box = new Box(4, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(173.20508075688772);
    }

    @Test
    void cubeArea() {
        Box box = new Box(8, 10);
        double area = box.getArea();
        assertThat(area).isEqualTo(600.0);
    }
}