package app.kitchen;

import app.ConsoleHelper;


import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {

    String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cook{" +
                "name='" + name + '\'' +
                '}';
    }



    @Override
    public void update(Observable o, Object order) {
//        if (!((Order) order).isEmpty()) {
            ConsoleHelper.writeMessage("Start cooking - " + order
                    + ", cooking time " + ((Order)order).getTotalCookingTime() + " min");
            setChanged();
            notifyObservers(order);
//        }
    }

}
