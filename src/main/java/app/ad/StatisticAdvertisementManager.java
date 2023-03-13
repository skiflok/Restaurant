package app.ad;

import app.ConsoleHelper;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {

    private static final StatisticAdvertisementManager instance = new StatisticAdvertisementManager();
    private final AdvertisementStorage advertisementStorage = AdvertisementStorage.getStorage();


    private StatisticAdvertisementManager() {
    }

    public static StatisticAdvertisementManager getInstance() {
        return instance;
    }

    /**
     * список активных роликов и оставшееся количество показов по каждому
     */
    public List<Advertisement> getVideoSet(boolean isActive) {
        List<Advertisement> videoSet = new ArrayList<>();

        for (Advertisement advertisement : advertisementStorage.list()) {
            if (!isActive ^ advertisement.isAlive()) {
                videoSet.add(advertisement);
            }
        }

        return videoSet;
    }

}
