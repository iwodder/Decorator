package com.wodder.pizza;

import java.util.ArrayList;

public class DeepDish extends PizzaCrust {
    private final double cost = 5.99;

    public DeepDish() {
        this.description = "Deep dish crust";
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
