package ru.job4j.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        Generics generics = new Generics();
        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();
        first.add(new Animal());
        second.add(new Predator());
        third.add(new Tiger());

        generics.printObject(first);
        generics.printObject(second);
        generics.printObject(third);
        System.out.println();

        generics.printBoundedWildCard(second); // Изменено на List<Predator>
        generics.printBoundedWildCard(third);  // Изменено на List<Predator>
        System.out.println();

        generics.printLowerBoundedWildCard(first); // Изменено на List<Animal>
        generics.printLowerBoundedWildCard(second); // Изменено на List<Animal>
    }

    public void printObject(List<?> list) { // Меняем параметр на ограниченный метасимвольный тип
        for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

    public void printBoundedWildCard(List<? extends Predator> list) { // Меняем параметр на ограниченный метасимвольный тип
        for (Iterator<? extends Predator> iterator = list.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

    public void printLowerBoundedWildCard(List<? super Predator> list) { // Меняем параметр на ограниченный метасимвольный тип
        for (Iterator<? super Predator> iterator = list.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Текущий элемент: " + next);
        }
    }
}

