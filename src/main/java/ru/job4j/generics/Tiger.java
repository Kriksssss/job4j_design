package ru.job4j.generics;

class Tiger extends Predator {
    private String stripePattern;

    public Tiger(String name, int teethCount, String stripePattern) {
        super(name, teethCount);
        this.stripePattern = stripePattern;
    }

    public Tiger() {

    }

    public String getStripePattern() {
        return stripePattern;
    }

    @Override
    public String toString() {
        return "Tiger: " + getName()
                + ", Teeth Count: " + getTeethCount()
                + ", Stripe Pattern: " + stripePattern;
    }
}
