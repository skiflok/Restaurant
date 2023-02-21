package app;


import app.kitchen.Cook;

import java.io.*;
import java.util.logging.Logger;

public class App {

    private final static Logger logger = Logger.getLogger(Tablet.class.getName());
    public static void main(String[] args) throws IOException {


        InputStream sysInBackup = System.in;
        ByteArrayInputStream is = new ByteArrayInputStream("FISH\nwater\nexit\n".getBytes());
        System.setIn(is);

        ConsoleHelper.writeMessage("it's a restaurant Restaurant");

        Tablet tablet1 = new Tablet(1);

        for (int i = 0; i < 4; ++i) {
            tablet1.createOrder();
            is.reset();
        }
        System.setIn(sysInBackup);

        Cook cook = new Cook("qwerty");
        System.out.println(cook);

    }
}

/*
fish
water
exit
* */