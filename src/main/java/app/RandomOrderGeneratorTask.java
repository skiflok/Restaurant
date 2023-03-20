package app;

import app.kitchen.Cook;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RandomOrderGeneratorTask implements Runnable {

    private final Logger logger = Logger.getLogger(RandomOrderGeneratorTask.class.getName());

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
//             int tablet = (int) (Math.random() * tablets.size());
             int tablet = (int) (ThreadLocalRandom.current().nextDouble() * tablets.size());
             logger.log(Level.INFO, "tablet = {0}", tablet);
             Tablet tableGeneratesAnOrder = tablets.get(tablet);
             tableGeneratesAnOrder.createTestOrder();
             Thread.sleep(interval);
            }
        } catch (InterruptedException ignored) {
        }
    }
}
