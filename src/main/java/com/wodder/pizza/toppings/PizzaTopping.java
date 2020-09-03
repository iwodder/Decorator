package com.wodder.pizza.toppings;

import com.wodder.pizza.Pizza;

import java.util.List;

public abstract class PizzaTopping extends Pizza {

    public abstract String getDescription();
    public abstract List<String> getDescriptions();
    public abstract void add(String s);
}
