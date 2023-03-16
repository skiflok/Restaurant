package app.kitchen;

import app.ConsoleHelper;
import app.statistic.StatisticEventManager;
import app.statistic.event.CookedOrderEventDataRow;


import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cook extends Observable implements Runnable {

    private final static Logger logger = Logger.getLogger(Cook.class.getName());

    String name;

    private boolean busy;

    private LinkedBlockingQueue<Order> orders;

    public void setOrders(LinkedBlockingQueue<Order> orders) {
        this.orders = orders;
    }

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

        logger.log(Level.INFO, "startCookingOrder" + this.name);

        busy = true;

        ConsoleHelper.writeMessage("Start cooking - " + order
                + ", cooking time " + order.getTotalCookingTime() + " min");
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

        logger.log(Level.INFO, "stop CookingOrder" + this.name);
    }

    @Override
    public void run() {
        logger.log(Level.INFO, "Запущен cookTread" + this.name);
        try {
            while (true) {

                if (!orders.isEmpty() && !this.isBusy()) {
                    this.startCookingOrder(orders.take());
                }
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "InterruptedException");
        }
    }
}
