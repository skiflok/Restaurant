package app;

import app.ad.Advertisement;
import app.ad.StatisticAdvertisementManager;
import app.statistic.StatisticEventManager;

import java.util.*;

public class DirectorTablet {

    /**
     * сумма заработанная на рекламе, сгруппировать по дням
     */
    public void printAdvertisementProfit() {
        long total = 0;
        TreeMap<String, Long> profitMap = new TreeMap<>(StatisticEventManager.getInstance().getAdvertisementProfit());
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
        TreeMap<String, Map<String, Integer>> cookWork = new TreeMap<>(StatisticEventManager.getInstance().getCookWorkLoading());
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
        List<Advertisement> videoSet = StatisticAdvertisementManager.getInstance().getVideoSet(true);
        videoSet.sort(Comparator.comparing(o -> o.getName().toLowerCase()));
        ConsoleHelper.writeMessage("ActiveVideoSet\n");
        for (Advertisement video : videoSet) {
            if (video.isAlive()) ConsoleHelper.writeMessage(video.getName() + "hits - "+ video.getHits());
        }
    }

    /**
     * список НЕ активных роликов (с оставшемся количеством показов равным нулю)
     */
    public void printArchivedVideoSet() {
        List<Advertisement> videoSet = StatisticAdvertisementManager.getInstance().getVideoSet(false);
        videoSet.sort(Comparator.comparing(o -> o.getName().toLowerCase()));
        ConsoleHelper.writeMessage("\nArchivedVideoSet\n");
        for (Advertisement video : videoSet) {
            if (!video.isAlive()) ConsoleHelper.writeMessage(video.getName() + "hits - "+ video.getHits());
        }
    }

}
