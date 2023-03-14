package app.kitchen;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {

    private LinkedBlockingQueue<Order> orders = new LinkedBlockingQueue<>();


    @Override
    public void update(Observable o, Object order) {
        try {
            orders.put((Order) order);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
