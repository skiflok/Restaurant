package app.kitchen;

import app.ConsoleHelper;
import app.statistic.StatisticEventManager;
import app.statistic.event.CookedOrderEventDataRow;


import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cook extends Observable {

    private final static Logger logger = Logger.getLogger(OrderManager.class.getName());

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

        logger.log(Level.INFO, "startCookingOrder");

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

        logger.log(Level.INFO, "stop CookingOrder");
    }
}
