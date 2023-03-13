package app.ad;

public class StatisticAdvertisementManager {

    private StatisticAdvertisementManager instance = new StatisticAdvertisementManager();

    private StatisticAdvertisementManager() {
    }

    public StatisticAdvertisementManager getInstance() {
        return instance;
    }
}
