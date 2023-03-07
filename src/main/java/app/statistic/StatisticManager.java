package app.statistic;


import app.statistic.event.EventDataRow;

/**
 * Управляет регистрацией событий и сбором статистики
 */
public class StatisticManager {

    private static final StatisticManager instance = new StatisticManager();

    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        return instance;
    }

    void register(EventDataRow data) {
        //TODO
    }
}
