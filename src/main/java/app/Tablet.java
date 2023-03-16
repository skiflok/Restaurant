package app;

import app.ad.AdvertisementManager;
import app.ad.NoVideoAvailableException;
import app.kitchen.Order;
import app.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.*;

/**
 * Планшет.
 * Создает заказы.
 * Показывает рекламу во время ожидания заказа
 */
public class Tablet {
    public Order order;
    private final int tableNumber;
    private final static Logger logger = Logger.getLogger(Tablet.class.getName());

    private LinkedBlockingQueue<Order> orders;

    public void setOrders(LinkedBlockingQueue<Order> orders) {
        this.orders = orders;
    }

    public Tablet(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    /**
     * Создает заказ (логика заполнения заказа в классе Order).
     * Уведомляет повара через обсервер о заказе.
     * Создает рекламного менеджера для показа рекламы.
     * Обрабатывает исключения:
     * ошибок ввода консоли,
     * отсутствие видео для показа
     */
    public void createOrder() {
//        logger.log(Level.INFO, "test");
        order = null;
        try {
            this.order = new Order(this);
            orderCreating();

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.", e);
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order, e);
        }
    }

    void createTestOrder() {
        order = null;
        try {
            this.order = new TestOrder(this);
            orderCreating();

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.", e);
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order, e);
        }
    }

    private void orderCreating() {
        if (!order.isEmpty()) {
            ConsoleHelper.writeMessage("thank you for your order");
            ConsoleHelper.writeMessage(order.toString());

            orders.offer(order);

            new AdvertisementManager(order.getTotalCookingTime() * 60).processVideos();
        } else {
            ConsoleHelper.writeMessage("your order is empty, try again");
        }
    }

    @Override
    public String toString() {
        return "{number=" + tableNumber + "}";
    }
}
