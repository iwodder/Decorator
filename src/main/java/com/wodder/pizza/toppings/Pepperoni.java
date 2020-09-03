package com.wodder.pizza.toppings;

import com.wodder.pizza.Pizza;

import java.util.List;

public class Pepperoni extends PizzaTopping {
    Pizza pizza;
    double cost = 0.99;
    private String description = "pepperoni";

    public Pepperoni(Pizza p) {
        this.pizza = p;
        this.pizza.add(description);
    }

    @Override
    public double cost() {
        return this.cost + pizza.cost();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", " + description;
    }

    @Override
    public List<String> getDescriptions() {
        return pizza.getDescriptions();
    }

    @Override
    public void add(String s) {
        pizza.add(s);
    }
}
