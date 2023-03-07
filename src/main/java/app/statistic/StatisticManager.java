package app.statistic;


/**
 * Управляет регистрацией событий и сбором статистики
 */
public class StatisticManager {

    private static final StatisticManager instance = new StatisticManager();

    private StatisticManager() {    }

    public static StatisticManager getInstance() {
        return instance;
    }
}
