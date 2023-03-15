package app.kitchen;

import app.ConsoleHelper;
import app.statistic.StatisticEventManager;
import app.statistic.event.CookedOrderEventDataRow;


import java.util.Observable;


public class Cook extends Observable {

    String name;

    boolean isBusy;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cook{" +
                "name='" + name + '\'' +
                '}';
    }

    public boolean isBusy() {
        return isBusy;
    }

    void startCookingOrder(Order order) {
        isBusy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order
                + ", cooking time " +  order.getTotalCookingTime() + " min");
        StatisticEventManager.getInstance().register(
                new CookedOrderEventDataRow(
                        order.getTablet().toString(),
                        name,
                        order.getTotalCookingTime(),
                        order.getDishes()));

        try {
            Thread.sleep(order.getTotalCookingTime() / 60 * 10);
        } catch (InterruptedException ignored) {

        }
        setChanged();
        notifyObservers(order);
        isBusy = false;
    }
}
