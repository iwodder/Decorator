package com.wodder.pizza.toppings;

import com.wodder.pizza.PizzaCrust;

import java.util.List;

public abstract class Topping extends PizzaCrust {

    public abstract String getDescription();
    public abstract List<String> getL();
    public abstract void add(String s);
}
