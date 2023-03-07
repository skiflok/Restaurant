package app.statistic.event;

import app.kitchen.Dish;

import java.util.List;

public class CookedOrderEventDataRow {
    String tabletName;
    String cookName;
    int cookingTimeSeconds;
    List<Dish> cookingDishes;

    public CookedOrderEventDataRow(String tabletName,
                                   String cookName,
                                   int cookingTimeSeconds,
                                   List<Dish> cookingDishes) {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishes = cookingDishes;
    }
}
