package ru.job4j.generics;

public class Tiger extends Predator {
    public Tiger(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Tiger{"
                + "name='" + super.getName() + '\''
                + ", age=" + super.getAge()
                + '}';
    }
}
