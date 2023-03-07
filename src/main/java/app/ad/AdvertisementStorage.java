package app.ad;

import java.util.*;


/**
 * хранилище рекламных роликов
 */
public class AdvertisementStorage {

    private static AdvertisementStorage storage; // экземпляр хранилища синглтон
    private final List<Advertisement> videos = new LinkedList<>();


    private AdvertisementStorage() {
        Object someContent = new Object(); // временная заглушка
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min / 0.50$
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min / 0.10$
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min / 2.00$
        add(new Advertisement(someContent, "Fourth Video", 400, 20, 5 * 60)); //5 min / 0.20$
        add(new Advertisement(someContent, "Fifth Video", 1000, 20, 2 * 60)); //2 min / 0.50$
    }


    /**
     * возвращает список всех рекламных роликов
     * @return список рекламных роликов
     */
    public List<Advertisement> list() {
        return videos;
    }

    /**
     * добавляет рекламный ролик в список доступных к показу роликов
     * @param advertisement рекламный ролик
     */
    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }




    public static AdvertisementStorage getStorage () {
        if (storage == null) {
            storage = new AdvertisementStorage();
        }
        return storage;
    }

}
