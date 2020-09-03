package com.wodder.pizza;

public class DeepDishCrust extends Pizza {
    private final double cost = 5.99;

    public DeepDishCrust() {
        this.description = "Deep dish crust";
        this.add(this.description);
    }

    @Override
    public double cost() {
        return cost;
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }
}
