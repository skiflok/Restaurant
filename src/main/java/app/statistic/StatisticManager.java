package app.statistic;


import app.statistic.event.EventDataRow;
import app.statistic.event.EventType;
import app.statistic.event.VideoSelectedEventDataRow;

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
    private final StatisticStorage statisticStorage = new StatisticStorage();


    private StatisticManager() {
    }

    public static StatisticManager getInstance() {
        return instance;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    public long AdvertisementProfit() {
        long profit = 0;
        List<EventDataRow> eventDataRows = statisticStorage.storage.get(EventType.SELECTED_VIDEOS);
        for (EventDataRow row : eventDataRows) {
            profit +=((VideoSelectedEventDataRow) row).getAmount();
        }
        return profit;
    }


    private static class StatisticStorage {

        private final Map<EventType, List<EventDataRow>> storage = new HashMap<>();
        /**
         * Инициализирует хранилище с типами событий и пустым листом
         */
        public StatisticStorage() {
            for (EventType type : EventType.values()) {
                storage.put(type, new ArrayList<>());
            }
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

    }



}
