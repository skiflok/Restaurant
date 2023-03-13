package app;

import app.ad.Advertisement;
import app.ad.AdvertisementStorage;
import app.statistic.StatisticManager;

import java.util.Map;
import java.util.TreeMap;

public class DirectorTablet {

    AdvertisementStorage storage = AdvertisementStorage.getStorage();


    /**
     * сумма заработанная на рекламе, сгруппировать по дням
     */
    public void printAdvertisementProfit() {
        long total = 0;
        TreeMap<String, Long> profitMap = new TreeMap<>(StatisticManager.getInstance().getAdvertisementProfit());
        for (Map.Entry<String, Long> dateProfit : profitMap.entrySet()) {
            ConsoleHelper.writeMessage(String.format("date - %s, AdvertisementProfit - %5.2f$",
                    dateProfit.getKey(), dateProfit.getValue() / 100.0));
            total += dateProfit.getValue();
        }
        ConsoleHelper.writeMessage(String.format("Total - %5.2f$\n", total/100.0));
    }

    /**
     * загрузка (рабочее время) повара, сгруппировать по дням
     */
    public void printCookWorkLoading() {
        TreeMap<String, Map<String, Integer>> cookWork = new TreeMap<>(StatisticManager.getInstance().getCookWorkLoading());
        for (Map.Entry<String, Map<String, Integer>> dateWork : cookWork.entrySet()) {
            ConsoleHelper.writeMessage(String.format("date - %s", dateWork.getKey()));
            for (Map.Entry<String, Integer> cook : dateWork.getValue().entrySet()) {
                ConsoleHelper.writeMessage(String.format("name - %10s, workTime - %5d min",
                        cook.getKey(), cook.getValue()));
            }
        }
        ConsoleHelper.writeMessage("");
    }


    /**
     * список активных роликов и оставшееся количество показов по каждому
     */
    public void printActiveVideoSet() {
        ConsoleHelper.writeMessage("ActiveVideoSet\n");
        for (Advertisement video : storage.list()) {
            if (video.isAlive()) ConsoleHelper.writeMessage(video.getName() + "hits - "+ video.getHits());
        }
    }

    /**
     * список НЕ активных роликов (с оставшемся количеством показов равным нулю)
     */
    public void printArchivedVideoSet() {
        ConsoleHelper.writeMessage("\nArchivedVideoSet\n");
        for (Advertisement video : storage.list()) {
            if (!video.isAlive()) ConsoleHelper.writeMessage(video.getName() + "hits - "+ video.getHits());
        }
    }

}
