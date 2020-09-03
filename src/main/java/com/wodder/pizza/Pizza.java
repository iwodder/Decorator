package com.wodder.pizza;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
  protected String description = "No description";
  private List<String> descriptions = new ArrayList<>();
  public abstract double cost();

  public String getDescription() {
    return description;
  }

  public List<String> getDescriptions() {
    return descriptions;
  }

  public void add(String s) {
    descriptions.add(s);
  }
}
