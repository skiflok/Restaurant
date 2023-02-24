package app.ad;

import java.util.*;

public class AdvertisementStorage {

    private static AdvertisementStorage storage;
    private final List<Advertisement> videos = new LinkedList<>();


    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min
    }

    public List<Advertisement> list() {
        return videos;
    }

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
