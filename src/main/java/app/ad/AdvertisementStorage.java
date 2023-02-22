package app.ad;

public class AdvertisementStorage {

    private static AdvertisementStorage storage;
    private AdvertisementStorage() {}

    public static AdvertisementStorage getStorage () {
        if (storage == null) {
            storage = new AdvertisementStorage();
        }

        return storage;
    }

}
