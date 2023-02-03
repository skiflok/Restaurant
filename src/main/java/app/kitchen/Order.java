package app.kitchen;

import app.ConsoleHelper;
import app.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        if (dishes.isEmpty()) {
            return "";
        } else {
            return "Order{" +
                    "tablet=" + tablet +
                    ", dishes=" + dishes +
                    '}';
        }
    }
}
