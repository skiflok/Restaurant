package app;


import app.kitchen.Cook;
import app.kitchen.Waiter;
import app.statistic.StatisticEventManager;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static int ORDER_CREATING_INTERVAL = 100;

    //    private final static Logger logger = Logger.getLogger(Tablet.class.getName());
    public static void main(String[] args) {

        ConsoleHelper.writeMessage("it's a restaurant Restaurant");

        Cook cook = new Cook("Cook_1");
        Cook cook2 = new Cook("Cook_2");
        StatisticEventManager.getInstance().register(cook);
        StatisticEventManager.getInstance().register(cook);

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tablets.add(new Tablet(i));
            tablets.get(i).addObserver(cook);
            tablets.get(i).addObserver(cook2);

        }

        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        cook2.addObserver(waiter);

        tablets.get(0).createTestOrder();

        tablets.get(1).createTestOrder();

        ConsoleHelper.writeMessage("\n");

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkLoading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }
}
