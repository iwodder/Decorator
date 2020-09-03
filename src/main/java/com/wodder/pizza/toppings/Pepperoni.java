package com.wodder.pizza.toppings;

import com.wodder.pizza.PizzaCrust;

import java.util.List;

public class Pepperoni extends Topping {
    PizzaCrust pizzaCrust;
    double cost = 0.99;

    public Pepperoni(PizzaCrust p) {
        this.pizzaCrust = p;
        this.pizzaCrust.add("pepperoni");
    }

    @Override
    public double cost() {
        return this.cost + pizzaCrust.cost();
    }

    @Override
    public String getDescription() {
        return pizzaCrust.getDescription() + ", Pepperoni";
    }

    @Override
    public List<String> getL() {
        return pizzaCrust.getL();
    }

    @Override
    public void add(String s) {
        pizzaCrust.add(s);
    }
}
