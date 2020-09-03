package com.wodder.pizza.util;

import com.wodder.pizza.Pizza;
import com.wodder.pizza.toppings.PizzaTopping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrettyPizzaPrinter extends PizzaTopping {
  Pizza pizza;

  public PrettyPizzaPrinter(Pizza p) {
    this.pizza = p;
  }

  @Override
  public double cost() {
    return pizza.cost();
  }

  @Override
  public String getDescription() {
    return prettyPrint(new ArrayList<>(pizza.getDescriptions()));
  }

  @Override
  public List<String> getDescriptions() {
    return pizza.getDescriptions();
  }

  @Override
  public void add(String s) {
    throw new UnsupportedOperationException("Cannot add a new description to this topping.");
  }

  private String prettyPrint(List<String> descriptions) {
    StringBuilder sb = new StringBuilder();
    while (descriptions.size() > 0) {
      Iterator<String> iter = descriptions.iterator();
      String description = iter.next();
      iter.remove();
      String qualifier = getQualifier(getCount(description, iter));
      if (!qualifier.isEmpty()) {
        sb.append(qualifier).append(" ");
      }
      sb.append(description);
      if (descriptions.size() > 0) {
        sb.append(", ");
      }
    }
    replaceFirstComma(sb);
    replaceLastComma(sb);
    addCost(sb);
    return sb.toString();
  }

  private void replaceFirstComma(StringBuilder sb) {
    int firstComma = sb.indexOf(",");
    if (firstComma > 0) {
      sb.replace(firstComma, ++firstComma, " with");
    }
  }

  private void replaceLastComma(StringBuilder sb) {
    int lastComma = sb.lastIndexOf(",");
    if (lastComma > 0) {
      sb.replace(lastComma, ++lastComma, ", and");
    }
  }

  private void addCost(StringBuilder sb) {
    sb.append(" costs ");
    sb.append(String.format("$%.2f", this.cost()));
  }

  private String getQualifier(int cnt) {
    switch (cnt) {
      case 1:
        return "";
      case 2:
        return "double";
      case 3:
        return "triple";
      case 4:
        return "quad";
      default:
        return "ultimate";
    }
  }

  private int getCount(String desc, Iterator<String> i) {
    int cnt = 1;
    while (i.hasNext()) {
      if (i.next().equals(desc)) {
        cnt++;
        i.remove();
      }
    }
    return cnt;
  }
}
