package com.wodder;

import com.wodder.pizza.DeepDishCrust;
import com.wodder.pizza.RegularCrust;
import com.wodder.pizza.ThinCrust;
import com.wodder.pizza.Pizza;
import com.wodder.pizza.toppings.*;
import com.wodder.pizza.util.PrettyPizzaPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class App {
  private static Scanner s = new Scanner(System.in);
  private static List<Pizza> pizzaOrder = new ArrayList<>();
  private static Pizza currentPizza;

  public static void main(String[] args) {
    printWelcome();
    while (true) {
      chooseCrust();
      addToppings();
      addPizzaToOrder();
    }
  }

  private static void printWelcome() {
    System.out.println("=======================================");
    System.out.println("==          Ian's Pizza Cafe         ==");
    System.out.println("=======================================");
    System.out.println();
    System.out.println("Leave any time by typing exit");
    System.out.println("Now, let's make some pizzas!");
    System.out.println();
  }

  private static void chooseCrust() {
    System.out.println("Start by selecting a crust type");
    System.out.println();
    printCrustChoices();
    getChoice(crustChoice);
  }

  private static void addToppings() {
    System.out.println("What toppings would you like to add?");
    System.out.println();
    while (true) {
      printToppingChoices();
      getChoice(toppingChoice);
      if (noMore("Would you like to add more toppings? (y/n)")) {
        break;
      }
    }
  }

  private static void addPizzaToOrder() {
    Pizza p = new PrettyPizzaPrinter(currentPizza);
    System.out.println("Great order!");
    System.out.println(p.getDescription());
    System.out.println();
    pizzaOrder.add(p);
    if (noMore("Order another pizza? (y/n)")) {
      exitApp();
    }
  }

  private static void printCrustChoices() {
    System.out.println("1) Regular Crust");
    System.out.println("2) Thin Crust");
    System.out.println("3) Deep dish Crust");
  }

  private static void printToppingChoices() {
    System.out.println("1) Tomato Sauce");
    System.out.println("2) Cheese");
    System.out.println("3) Sausage");
    System.out.println("4) Pepperoni");
    System.out.println("5) Tomato");
    System.out.println("6) Onion");
  }

  private static boolean noMore(String out) {
    System.out.println(out);
    while (true) {
      try {
        return no();
      } catch (IllegalArgumentException iea) {
        System.out.println(iea.getMessage());
      }
    }
  }

  private static void getChoice(Consumer<String> choiceConsumer) {
    while (true) {
      try {
        choiceConsumer.accept(getInput());
        break;
      } catch (NumberFormatException pe) {
        System.out.println("Please enter a number");
      } catch (IllegalArgumentException iae) {
        System.out.println(iae.getMessage());
      }
    }
  }

  private static boolean no() {
    return !yesNo(getInput());
  }

  private static boolean yes() {
    return yesNo(getInput());
  }

  private static boolean yesNo(String in) {
    if ("y".equalsIgnoreCase(in)) {
      return true;
    } else if ("n".equalsIgnoreCase(in)) {
      return false;
    } else {
      throw new IllegalArgumentException("Please enter 'y' or 'n'");
    }
  }

  private static Consumer<String> crustChoice =
      s -> {
        int i = Integer.parseInt(s);
        switch (i) {
          case 1:
            currentPizza = new RegularCrust();
            break;
          case 2:
            currentPizza = new ThinCrust();
            break;
          case 3:
            currentPizza = new DeepDishCrust();
            break;
          default:
            throw new IllegalArgumentException(String.format("No crust type for choice %d", i));
        }
      };

  private static Consumer<String> toppingChoice =
      s -> {
        int i = Integer.parseInt(s);
        switch (i) {
          case 1:
            currentPizza = new TomatoSauce(currentPizza);
            break;
          case 2:
            currentPizza = new Cheese(currentPizza);
            break;
          case 3:
            currentPizza = new Sausage(currentPizza);
            break;
          case 4:
            currentPizza = new Pepperoni(currentPizza);
            break;
          case 5:
            currentPizza = new Tomato(currentPizza);
            break;
          case 6:
            currentPizza = new Onion(currentPizza);
            break;
          default:
            throw new IllegalArgumentException(String.format("No topping for choice %d", i));
        }
      };

  private static String getInput() {
    System.out.print("> ");
    String in = s.next();
    if (in.equalsIgnoreCase("exit")) {
      exitApp();
    }
    return in;
  }

  private static void exitApp() {
    System.out.println("Goodbye... Come see us again soon!");
    System.exit(0);
  }
}
