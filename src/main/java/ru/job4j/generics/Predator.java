package ru.job4j.generics;

class Predator extends Animal {
    private int teethCount;

    public Predator(String name, int teethCount) {
        super(name);
        this.teethCount = teethCount;
    }

    public Predator() {

    }

    public int getTeethCount() {
        return teethCount;
    }

    @Override
    public String toString() {
        return "Predator: " + getName() + ", Teeth Count: " + teethCount;
    }
}
