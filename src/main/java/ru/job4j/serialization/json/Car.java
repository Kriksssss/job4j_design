package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Car {
    private final boolean isElectric;
    private final int yearOfManufacture;
    private final String model;
    private final Engine engine;
    private final String[] features;

    public Car(boolean isElectric, int yearOfManufacture, String model, Engine engine, String[] features) {
        this.isElectric = isElectric;
        this.yearOfManufacture = yearOfManufacture;
        this.model = model;
        this.engine = engine;
        this.features = features;
    }


    @Override
    public String toString() {
        return "Car{"
                + "isElectric=" + isElectric
                + ", yearOfManufacture=" + yearOfManufacture
                + ", model='" + model + '\''
                + ", engine=" + engine
                + ", features=" + Arrays.toString(features)
                + '}';
    }

    public static void main(String[] args) {
        Engine carEngine = new Engine("Electric", 503);
        Car teslaModelS = new Car(true, 2022, "Tesla Model S", carEngine,
                new String[]{"Autopilot", "Smart Summon", "Full Self-Driving"});

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonCar = gson.toJson(teslaModelS);
        System.out.println("JSON representation:\n" + jsonCar);

        Car restoredCar = gson.fromJson(jsonCar, Car.class);
        System.out.println("\nRestored Car:\n" + restoredCar);
    }
}

class Engine {
    private final String type;
    private final int horsepower;

    public Engine(String type, int horsepower) {
        this.type = type;
        this.horsepower = horsepower;
    }
}


