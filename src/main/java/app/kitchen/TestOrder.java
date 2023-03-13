package app.kitchen;


import app.Tablet;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Случайным образом генерирует заказы
 */
public class TestOrder extends Order{

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

    protected void initDishes() {
        this.dishes = new ArrayList<>();
        Dish[] dish = Dish.values();
        int countDishes = (int) (Math.random() * 3 + 2);
        for (int i = 0; i < countDishes; ++i) {
            dishes.add(dish[i]);
        }
    }

}
