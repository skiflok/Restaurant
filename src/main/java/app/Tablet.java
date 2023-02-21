package app;

import app.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.*;

public class Tablet extends Observable {
    public Order order;
    private final int tableNumber;
    private final static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void createOrder()  {
//        logger.log(Level.INFO, "test");
        order = null;
        try {
            this.order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            setChanged();
            notifyObservers(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.", e);
        }
    }

    @Override
    public String toString() {
        return "{number=" + tableNumber + "}";
    }
}
