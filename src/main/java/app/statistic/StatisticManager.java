package app.statistic;


import app.statistic.event.EventDataRow;
import app.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Управляет регистрацией событий и сбором статистики.
 * Имеет хранилище в виде внутреннего класса.
 */
public class StatisticManager {

    private static final StatisticManager instance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();


    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        return instance;
    }

    void register(EventDataRow data) {
        //TODO
    }


    private class StatisticStorage {

        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();


        /**
         * Инициализирует хранилище с типами событий и пустым листом
         */
        public StatisticStorage() {
            for (EventType type : EventType.values()) {
                storage.put(type, new ArrayList<EventDataRow>());
            }
        }
    }

}
