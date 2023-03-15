package app.kitchen;

import app.ConsoleHelper;
import app.Tablet;
import app.statistic.StatisticEventManager;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Обсервер для столиков.
 */
public class OrderManager implements Observer {

    private final static Logger logger = Logger.getLogger(OrderManager.class.getName());
    private LinkedBlockingQueue<Order> orders = new LinkedBlockingQueue<>();

    public OrderManager() {
        logger.log(Level.INFO, getClass().getName());
        Thread passOrderToCook = new Thread(() -> {
            logger.log(Level.INFO, "Запущен passOrderToCook");

            Set<Cook> cooks = StatisticEventManager.getInstance().getCooks();

            while (true) {
                try {
                    for (Cook cook : cooks) {
                        if (!cook.isBusy() && !orders.isEmpty()) {
                            cook.startCookingOrder(orders.take());
                            break;
                        }
                    }
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    logger.log(Level.SEVERE, "InterruptedException");
                }
            }
        });
        passOrderToCook.setDaemon(true);
        passOrderToCook.start();
    }

    @Override
    public void update(Observable o, Object order) {
        try {
            orders.put((Order) order);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
