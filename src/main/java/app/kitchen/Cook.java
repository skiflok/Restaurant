package app.kitchen;

import app.ConsoleHelper;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Cook implements Observer {

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
    public void update(Observable o, Object arg) {
        ConsoleHelper.writeMessage("Start cooking - " + arg);
    }
}
