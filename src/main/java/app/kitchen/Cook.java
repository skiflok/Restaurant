package app.kitchen;

import app.ConsoleHelper;
import app.statistic.StatisticEventManager;
import app.statistic.event.CookedOrderEventDataRow;


import java.util.Observable;


public class Cook extends Observable {

    String name;

    private boolean busy;

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
        return busy;
    }

    void startCookingOrder(Order order) {
        busy = true;
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
        busy = false;
    }
}
