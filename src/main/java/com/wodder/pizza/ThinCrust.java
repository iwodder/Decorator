package com.wodder.pizza;

public class ThinCrust extends Pizza {
    private final double cost = 3.99;

    public ThinCrust() {
        this.description = "Thin crust";
        this.add(this.description);
    }

    @Override
    public double cost() {
        return this.cost;
    }
}
