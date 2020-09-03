package com.wodder;

import com.wodder.pizza.ThinCrust;
import com.wodder.pizza.PizzaCrust;
import com.wodder.pizza.toppings.Pepperoni;

import java.util.Arrays;

public class App {
    public static void main( String[] args ) {
        PizzaCrust pizzaCrust = new Pepperoni(new Pepperoni(new ThinCrust()));
        System.out.println(pizzaCrust.getDescription() + " costs $" + pizzaCrust.cost());
        System.out.println(Arrays.toString(pizzaCrust.getL().toArray()));
        int i = 1;
        i--;
    }
}
