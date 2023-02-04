package app;




import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("it's a restaurant Restaurant");
        Tablet tablet1 = new Tablet(1);
        tablet1.createOrder();
        ConsoleHelper.writeMessage(tablet1.order.toString());
    }
}

/*
fish
water
exit
* */