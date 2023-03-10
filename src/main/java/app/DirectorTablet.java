package app;

import app.statistic.StatisticManager;

import java.util.Map;
import java.util.TreeMap;

public class DirectorTablet {


    /**
     * сумма заработанная на рекламе, сгруппировать по дням
     */
    public void printAdvertisementProfit() {
        TreeMap<String, Long> profitMap = new TreeMap<>(StatisticManager.getInstance().getAdvertisementProfit());
        for (Map.Entry<String, Long> dateProfit : profitMap.entrySet()) {
            ConsoleHelper.writeMessage(String.format("date - %s, AdvertisementProfit - %5.2f$",
                    dateProfit.getKey(), dateProfit.getValue() / 100.0));
        }
        ConsoleHelper.writeMessage("");
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
        //TODO
    }

    /**
     * список НЕ активных роликов (с оставшемся количеством показов равным нулю)
     */
    public void printArchivedVideoSet() {
        //TODO
    }

}
