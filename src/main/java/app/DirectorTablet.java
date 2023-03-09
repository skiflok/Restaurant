package app;

import app.statistic.StatisticManager;

public class DirectorTablet {


    /**
     * сумма заработанная на рекламе, сгруппировать по дням
     */
    public void printAdvertisementProfit() {
        ConsoleHelper.writeMessage(((Long) StatisticManager.getInstance().AdvertisementProfit()).toString());
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
