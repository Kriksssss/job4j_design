package ru.job4j.generics;

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Animal: " + name;
    }
}
