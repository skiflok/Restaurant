package app.statistic.event;

import app.kitchen.Dish;

import java.util.Date;
import java.util.List;


/**
 *  Создает объект для сбора статистики по заказу.
 *  Номер столика, имя повара, время приготовления, список блюд
 */
public class CookedOrderEventDataRow implements EventDataRow{
    String tabletName;
    String cookName;
    int cookingTimeSeconds;
    List<Dish> cookingDishes;

    Date currentDate;

    public CookedOrderEventDataRow(String tabletName,
                                   String cookName,
                                   int cookingTimeSeconds,
                                   List<Dish> cookingDishes) {
        this.tabletName = tabletName;
        this.cookName = cookName;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookingDishes = cookingDishes;
        this.currentDate = new Date();
    }

    /**
     * возвращает тип события
     * @return возвращает тип события (приготовление заказа)
     */
    @Override
    public EventType getType() {
        return EventType.COOKED_ORDER;
    }
}
