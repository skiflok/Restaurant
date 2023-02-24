package app.ad;

import app.ConsoleHelper;

import java.util.List;

public class AdvertisementManager {

    private final AdvertisementStorage storage = AdvertisementStorage.getStorage();

    int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        } else {
            List<Advertisement> playlist = storage.list();
            for (Advertisement video : playlist) {
                ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                        video.getName(),
                        video.getAmountPerOneDisplaying(),
                        video.getAmountPerOneDisplaying() * 1000 / video.getDuration()));
            }
        }
    }
}
