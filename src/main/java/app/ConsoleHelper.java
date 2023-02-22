package app;

import app.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {

    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));


    public static void writeMessage(String message) {
        System.out.println(message);
    }
    public static String readString() throws IOException {
        return bis.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        writeMessage("it's our dishes");
        writeMessage(Dish.allDishesToString());
        writeMessage("please select dishes, to complete enter \"exit\"");
        String guestOrder = readString().trim();
        Dish dish;
        while (!guestOrder.equals("exit")) {

            try {
                dish = Dish.valueOf(guestOrder.toUpperCase());
                dishes.add(dish);
                writeMessage(dish + " add to your order");
            } catch (IllegalArgumentException exception) {
                writeMessage("This dish is not on the menu, please try again");
            }
            guestOrder = readString().trim();
        }
        return dishes;
    }

}
