package com.wodder.pizza;

public class RegularCrust extends PizzaCrust {
    private final double cost = 4.99;

    public RegularCrust() {
        this.description = "Regular crust";
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
