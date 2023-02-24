package app.ad;

import app.ConsoleHelper;

import java.util.Collections;
import java.util.Comparator;
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
            /*
            Пример метода сортировки коллекций (List<T>, Comparator<? super T>) [дубликат]
            https://stackoverflow.com/questions/14154127/collections-sortlistt-comparator-super-t-method-example
             */
            Collections.sort(playlist, new Comparator<Advertisement>() {
                @Override
                public int compare(Advertisement o1, Advertisement o2) {
                    long l = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
                    return (int) (l != 0 ? l : o2.getDuration() - o1.getDuration());
                }
            });
            for (Advertisement video : playlist) {
                ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                        video.getName(),
                        video.getAmountPerOneDisplaying(),
                        video.getAmountPerOneDisplaying() * 1000 / video.getDuration()));
            }
        }
    }
}
