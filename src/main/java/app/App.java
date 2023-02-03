package app;


import app.kitchen.Dish;

public class App {
    public static void main(String[] args) {
        ConsoleHelper.writeMessage("it's a restaurant Restaurant");
        ConsoleHelper.writeMessage("it's our dishes");
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        ConsoleHelper.writeMessage("please select dishes, to complete enter \"exit\"");


    }
}

