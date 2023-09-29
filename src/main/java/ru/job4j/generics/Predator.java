package ru.job4j.generics;

public class Predator extends Animal {
    public Predator(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Predator{"
                + "name='" + super.getName() + '\''
                + ", age=" + super.getAge()
                + '}';
    }
}
