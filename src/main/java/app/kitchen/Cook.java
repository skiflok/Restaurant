package app.kitchen;

import app.ConsoleHelper;
import app.statistic.StatisticManager;
import app.statistic.event.CookedOrderEventDataRow;


import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {

    String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cook{" +
                "name='" + name + '\'' +
                '}';
    }


    @Override
    public void update(Observable o, Object order) {
//        if (!((Order) order).isEmpty()) {
        ConsoleHelper.writeMessage("Start cooking - " + order
                + ", cooking time " + ((Order) order).getTotalCookingTime() + " min");
        StatisticManager.getInstance().register(
                new CookedOrderEventDataRow(
                        ((Order) order).getTablet().toString(),
                        name,
                        ((Order) order).getTotalCookingTime(),
                        ((Order) order).getDishes()));
        setChanged();
        notifyObservers(order);
//        }
    }

}
