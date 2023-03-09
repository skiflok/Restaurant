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
        for (Map.Entry <String, Long> dateProfit: profitMap.entrySet()) {
            ConsoleHelper.writeMessage(String.format("date - %s, AdvertisementProfit - %5.2f$",
                    dateProfit.getKey(), dateProfit.getValue()/100.0));
        }
    }

    /**
     * загрузка (рабочее время) повара, сгруппировать по дням
     */
    public void printCookWorkLoading() {
        //TODO
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
