package app;


import app.kitchen.Dish;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("it's a restaurant Restaurant");
        ConsoleHelper.getAllDishesForOrder();
    }
}

