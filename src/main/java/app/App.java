package app;



import app.kitchen.Order;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("it's a restaurant Restaurant");
//        ConsoleHelper.getAllDishesForOrder();
        Order order = new Order(new Tablet(1));
        ConsoleHelper.writeMessage(order.toString());
    }
}

/*
fish
water
exit
* */