package app;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {

    private List<Tablet> tablets;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tablets, int interval) {
        this.tablets = tablets;
        this.interval = interval;
    }



    @Override
    public void run() {
        try {
            while (true) {
             int tablet = (int) (Math.random() * tablets.size());
             Tablet tableGeneratesAnOrder = tablets.get(tablet);
             tableGeneratesAnOrder.createOrder();
             Thread.sleep(interval);
            }
        } catch (InterruptedException ignored) {
        }
    }
}
