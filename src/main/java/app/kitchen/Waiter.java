package app.kitchen;

import app.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Waiter implements Observer, Runnable {

    private final Logger logger = Logger.getLogger(Waiter.class.getName());

    private LinkedBlockingQueue<Order> delivery;

    public void setDelivery(LinkedBlockingQueue<Order> delivery) {
        this.delivery = delivery;
    }

    @Override
    public void update(Observable cook, Object order) {

        ConsoleHelper.writeMessage(order + "was cooked" + cook);

    }

    public void carryOrder () throws InterruptedException {
        Order order = delivery.take();
//        ConsoleHelper.writeMessage(order + "was cooked " + cook);
    }

    @Override
    public void run() {
        logger.log(Level.INFO, "Запущен Waiter {0}", this.getClass().getSimpleName());
        try {
            while (true) {

                if (!delivery.isEmpty()) {
                    carryOrder();
                }

            }
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "InterruptedException");
        }
    }
}
