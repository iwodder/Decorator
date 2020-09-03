package com.wodder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.wodder.pizza.DeepDishCrust;
import com.wodder.pizza.Pizza;
import com.wodder.pizza.RegularCrust;
import com.wodder.pizza.ThinCrust;
import com.wodder.pizza.toppings.Cheese;
import com.wodder.pizza.toppings.Pepperoni;
import com.wodder.pizza.toppings.Sausage;
import com.wodder.pizza.toppings.TomatoSauce;
import com.wodder.pizza.util.PrettyPizzaPrinter;
import org.junit.Before;
import org.junit.Test;


public class AppTest {
    private Pizza testPizza;

    @Before
    public void setup() {
         testPizza = new Pepperoni(new Pepperoni(new ThinCrust()));

    }

    @Test
    public void can_pretty_print() {
        Pizza prettyPrinter = new PrettyPizzaPrinter(testPizza);
        assertEquals("Thin crust with double pepperoni costs $5.97", prettyPrinter.getDescription());
    }

    @Test
    public void returns_correct_cost() {
        assertEquals(5.97, testPizza.cost(), 0.01);
    }

    @Test
    public void should_have_three_descriptions() {
        assertEquals(3, testPizza.getDescriptions().size());
    }

    @Test
    public void multiple_calls_should_return_three() {
        assertEquals(3, testPizza.getDescriptions().size());
        assertEquals(3, testPizza.getDescriptions().size());
        assertEquals(3, testPizza.getDescriptions().size());
    }

    @Test
    public void prints_and_before_last_topping() {
        Pizza prettyPrinter = new PrettyPizzaPrinter(new Sausage(testPizza));
        assertEquals("Thin crust with double pepperoni, and sausage costs $7.46", prettyPrinter.getDescription());
    }

    @Test
    public void prints_comma_list_for_toppings() {
        Pizza prettyPrinter = new PrettyPizzaPrinter(new Cheese(new Sausage(testPizza)));
        assertEquals("Thin crust with double pepperoni, sausage, and cheese costs $9.45", prettyPrinter.getDescription());
    }

    @Test
    public void can_create_deep_dish() {
        Pizza prettyPrinter = new PrettyPizzaPrinter(
                new Pepperoni(new Cheese(new TomatoSauce(new DeepDishCrust()))));
        assertEquals("Deep dish crust with tomato sauce, cheese, and pepperoni costs $8.97", prettyPrinter.getDescription());
    }

    @Test
    public void can_create_regular_crust() {
        Pizza prettyPrinter = new PrettyPizzaPrinter(
                new Pepperoni(new Cheese(new TomatoSauce(new RegularCrust()))));
        assertEquals("Regular crust with tomato sauce, cheese, and pepperoni costs $7.97", prettyPrinter.getDescription());
    }
}
