package app;


import app.kitchen.Cook;
import app.kitchen.OrderManager;
import app.kitchen.Waiter;
import app.statistic.StatisticEventManager;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static int ORDER_CREATING_INTERVAL = 100;

    //    private final static Logger logger = Logger.getLogger(Tablet.class.getName());
    public static void main(String[] args) {

        ConsoleHelper.writeMessage("it's a restaurant Restaurant");

        Waiter waiter = new Waiter();
        OrderManager orderManager = new OrderManager();

        List<Cook> cooks = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Cook cook = new Cook("Cook_" + i);
            StatisticEventManager.getInstance().register(cook);
            cook.addObserver(waiter);
            cooks.add(cook);
        }

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablets.add(tablet);
            tablet.addObserver(orderManager);
        }

        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));

        try {
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
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
