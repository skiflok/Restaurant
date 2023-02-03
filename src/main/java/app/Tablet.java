package app;

public class Tablet {
    private final int tableNumber;

    public Tablet(int tableNumber) {
        this.tableNumber = tableNumber;
    }

//    public void createOrder() {
//
//    }

    @Override
    public String toString() {
        return "{number=" + tableNumber + "}";
    }
}
