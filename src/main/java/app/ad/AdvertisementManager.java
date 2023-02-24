package app.ad;

public class AdvertisementManager {

    private final AdvertisementStorage storage = AdvertisementStorage.getStorage();

    int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        }
    }
}
