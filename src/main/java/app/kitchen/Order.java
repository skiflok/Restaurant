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

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public int getTotalCookingTime() {
        int cookingTime = 0;
        for (Dish dish: dishes) {
            cookingTime += dish.getDuration();
        }
        return cookingTime;
    }

    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public String toString() {
        if (dishes.isEmpty()) {
            return null;
        } else {
            return "Your order: " + dishes + " of Tablet" + tablet;
        }
    }
}
