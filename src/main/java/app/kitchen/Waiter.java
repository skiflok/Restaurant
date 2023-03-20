package app.kitchen;

import app.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Waiter implements Runnable {

    private final Logger logger = Logger.getLogger(Waiter.class.getName());

    private LinkedBlockingQueue<Order> delivery;

    public void setDelivery(LinkedBlockingQueue<Order> delivery) {
        this.delivery = delivery;
    }

    public void carryOrder (Order order) throws InterruptedException {
        logger.log(Level.INFO, "Выдача заказа {0}", this.getClass().getSimpleName());
        ConsoleHelper.writeMessage(order + "was cooked " + order.getCook().name);
    }

    @Override
    public void run() {
        logger.log(Level.INFO, "Запущен Waiter {0}", this.getClass().getSimpleName());
        try {
            while (true) {

                if (!delivery.isEmpty()) {
                    carryOrder(delivery.take());
                }

            }
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "InterruptedException");
        }
    }
}
