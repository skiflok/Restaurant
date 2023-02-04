package app;

import app.kitchen.Order;

import java.io.IOException;

public class Tablet {
    private final int tableNumber;
    public Order order;



    public Tablet(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public void createOrder() throws IOException {
        this.order = new Order(this);
    }

    @Override
    public String toString() {
        return "{number=" + tableNumber + "}";
    }
}
