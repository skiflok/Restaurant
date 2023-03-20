package app;


import app.kitchen.Cook;
import app.kitchen.Order;
import app.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class App {
    private static int ORDER_CREATING_INTERVAL = 100;

    private static final LinkedBlockingQueue<Order> ORDERS = new LinkedBlockingQueue<>(200);
    private static final LinkedBlockingQueue<Order> DELIVERY = new LinkedBlockingQueue<>(200);
    //    private final static Logger logger = Logger.getLogger(Tablet.class.getName());
    public static void main(String[] args) {



        ConsoleHelper.writeMessage("it's a restaurant Restaurant");

        Waiter waiter = new Waiter();

        List<Cook> cooks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Cook cook = new Cook("Cook_" + i);
            cook.setOrders(ORDERS);
            cook.setDelivery(DELIVERY);
            cook.addObserver(waiter);
            cooks.add(cook);
        }

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setOrders(ORDERS);
            tablets.add(tablet);
        }

        List<Thread> cookThreads = new ArrayList<>();
        for (Cook cook : cooks) {
            Thread cookThread = new Thread(cook);
            cookThread.start();
            cookThreads.add(cookThread);
        }

        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();
        try {

            Thread.sleep(1000);
            thread.interrupt();
            thread.join();
            Thread.sleep(1000);
        } catch (Exception ignored) {

        }

        ConsoleHelper.writeMessage("\n");

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkLoading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }
}
