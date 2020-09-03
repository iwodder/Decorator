package com.wodder.pizza;

import java.util.ArrayList;
import java.util.List;

public abstract class PizzaCrust {
  protected String description = "No description";
  public List<String> l = new ArrayList<>();
  public abstract double cost();

  public String getDescription() {
    return description;
  }

  public List<String> getL() {
    return l;
  }

  public void add(String s) {
    l.add(s);
  }
}
