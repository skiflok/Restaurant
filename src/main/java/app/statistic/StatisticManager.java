package app.statistic;


import app.statistic.event.EventDataRow;
import app.statistic.event.EventType;
import app.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

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


    /**
     * Формирует мап {дата - суммарный доход от просмотра видео в этот день}.
     * @return мап {дата - суммарный доход от просмотра видео в этот день}
     */
    public Map<String, Long> getAdvertisementProfit() {
        Map<String, Long> profitMap = new HashMap<>();
        List<EventDataRow> eventDataRows = statisticStorage.storage.get(EventType.SELECTED_VIDEOS);

        for (EventDataRow row : eventDataRows) {
            VideoSelectedEventDataRow event = ((VideoSelectedEventDataRow) row);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            String date = dateFormat.format(event.getCurrentDate());
            if (!profitMap.containsKey(date)) {
                profitMap.put(date, event.getAmount());
            } else {
                profitMap.put(date, profitMap.get(date) + event.getAmount());
            }
        }
        return profitMap;
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
