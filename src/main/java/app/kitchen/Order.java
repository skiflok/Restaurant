package app.kitchen;

import app.Tablet;

import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List dishes;

    public Order(Tablet tablet) {
        this.tablet = tablet;
    }
}
