package app.ad;

import app.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Управляет показом рекламных роликов пользователю.
 * Подбирает ролики с целью получения максимальной выгоды от показа рекламы
 * во время приготовления конкретного заказа
 */
public class AdvertisementManager {

    private final AdvertisementStorage storage = AdvertisementStorage.getStorage();

    int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    private long maxAmount; // максимальная стоимость роликов

    private List<Advertisement> optimalPlaylist; // оптимальный плейлист

    private long availableTimeToShow; // доступное время для показа


    /**
     * подобрать рекламные ролики
     * требования
     * максимальная сумма денег от показа
     * время показа не превышает время приготовления
     * нет повторения роликов
     * если сумма одинаковая то выбрать максимальное время
     * если время одинаковое то выбрать минимальное количество роликов
     *
     * @param currentPlayList          текущий плейлист
     * @param currentAvailableTimeShow оставшееся доступное время для просмотра
     * @param currentAmount            доход от просмотра
     */
    private void createOptimalPlayList(List<Advertisement> currentPlayList,
                                       int currentAvailableTimeShow,
                                       long currentAmount) {
        if (currentAvailableTimeShow < 0) {
            return;
        } else if (currentAmount > maxAmount
                || currentAmount == maxAmount && (availableTimeToShow > currentAvailableTimeShow
                || availableTimeToShow == currentAvailableTimeShow && currentPlayList.size() < optimalPlaylist.size())) {
            this.availableTimeToShow = currentAvailableTimeShow;
            this.maxAmount = currentAmount;
            this.optimalPlaylist = currentPlayList;
            if (currentAvailableTimeShow == 0) return;
        }
        ArrayList<Advertisement> temp = getActualAdvertisements();
        temp.removeAll(currentPlayList);
        for (Advertisement video : temp) {
            if (!video.isAlive()) continue;
            ArrayList<Advertisement> currentListTemp = new ArrayList<>(currentPlayList);
            currentListTemp.add(video);
            createOptimalPlayList(currentListTemp,
                    currentAvailableTimeShow - video.getDuration(),
                    currentAmount + video.getAmountPerOneDisplaying());
        }
    }


    /**
     * получить видео с положительным количеством оплаченных показов
     *
     * @return список видео в доступных для показа
     */
    private ArrayList<Advertisement> getActualAdvertisements() {
        ArrayList<Advertisement> actualAdvertisements = new ArrayList<>();
        for (Advertisement video : storage.list()) {
            if (video.isAlive()) actualAdvertisements.add(video);
        }
        return actualAdvertisements;
    }


    /**
     * Запускает воспроизведение видео исходя из времени приготовления заказа.
     * Выполняет сортировку по стоимости за просмотр и по продолжительности
     */
    public void processVideos() {
        createOptimalPlayList(new ArrayList<>(), timeSeconds, 0L);
        if (optimalPlaylist == null || optimalPlaylist.isEmpty()) {
            throw new NoVideoAvailableException();
        } else {
            Collections.sort(optimalPlaylist, (o1, o2) -> {
                long l = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
                return (int) (l != 0 ? l : o2.getDuration() - o1.getDuration());
            });

            for (Advertisement video : optimalPlaylist) {
                playVideo(video);
                video.revalidate();
            }
        }
    }

    /**
     * Консольная имитация показа видео
     * 1 - название ролика,
     * 2- стоимость показа одного рекламного ролика в копейках,
     * 3 - стоимость показа одной секунды рекламного ролика в тысячных частях копейки.
     *
     * @param advertisement Рекламный ролик для воспроизведения.
     */
    private void playVideo(Advertisement advertisement) {
        ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                advertisement.getName(),
                advertisement.getAmountPerOneDisplaying(),
                advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration()));
    }
}
