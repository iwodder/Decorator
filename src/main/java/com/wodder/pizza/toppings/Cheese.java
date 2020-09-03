package com.wodder.pizza.toppings;

import com.wodder.pizza.Pizza;

import java.util.List;

public class Cheese extends PizzaTopping {
  Pizza pizza;
  private double cost = 1.99;
  private String description = "cheese";

  public Cheese(Pizza p) {
    this.pizza = p;
    this.pizza.add(description);
  }

  @Override
  public double cost() {
    return pizza.cost() + this.cost;
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
