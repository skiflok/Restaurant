package app;


import app.kitchen.Cook;
import app.kitchen.Waiter;

import java.io.*;
import java.util.logging.Logger;

public class App {

    //    private final static Logger logger = Logger.getLogger(Tablet.class.getName());
    public static void main(String[] args) throws IOException {


        InputStream sysInBackup = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("FISH\nwater\nexit\n".getBytes());
//        ByteArrayInputStream is = new ByteArrayInputStream("exit\n".getBytes());
//        ByteArrayInputStream is = new ByteArrayInputStream("not_hungry\nexit\n".getBytes());
        System.setIn(is);

        ConsoleHelper.writeMessage("it's a restaurant Restaurant");

        Tablet tablet1 = new Tablet(1);
        Cook cook = new Cook("Cook_1");
        tablet1.addObserver(cook);
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);

        for (int i = 0; i < 1; ++i) {
            tablet1.createOrder();
            is.reset();
        }
        System.setIn(sysInBackup);

    }
}

/*
fish
water
exit
* */