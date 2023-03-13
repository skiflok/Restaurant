package app;


import app.kitchen.Cook;
import app.kitchen.Waiter;

import java.io.*;

public class App {

    //    private final static Logger logger = Logger.getLogger(Tablet.class.getName());
    public static void main(String[] args) {


        InputStream sysInBackup = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("FISH\nwater\nexit\n".getBytes());
//        ByteArrayInputStream is = new ByteArrayInputStream("exit\n".getBytes());
//        ByteArrayInputStream is = new ByteArrayInputStream("not_hungry\nexit\n".getBytes());
        System.setIn(is);

        ConsoleHelper.writeMessage("it's a restaurant Restaurant");

        Tablet tablet1 = new Tablet(1);
        Tablet tablet2 = new Tablet(2);
        Cook cook = new Cook("Cook_1");
        Cook cook2 = new Cook("Cook_2");
        tablet1.addObserver(cook);
        tablet2.addObserver(cook2);
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        cook2.addObserver(waiter);

        for (int i = 0; i < 1; ++i) {
            tablet1.createOrder();
            is.reset();
        }
        tablet2.createOrder();

        System.setIn(sysInBackup);

        ConsoleHelper.writeMessage("\n");

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkLoading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();

    }
}

/*
fish
water
exit
* */