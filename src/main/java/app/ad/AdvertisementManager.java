package app.ad;

import app.ConsoleHelper;

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

    /*
    *   задача
    * подобрать рекламные ролики
    *   требования
    * максимальная сумма денег от показа
    * время показа не превышает время приготовления
    * нет повторения роликов
    * если сумма одинаковая то выбрать максимальное время
    * если время одинаковое то выбрать минимальное количество роликов
    * */



    /**
     * Запускает воспроизведение видео исходя из времени приготовления заказа.
     * Выполняет сортировку по стоимости за просмотр и по продолжительности
     */
    public void processVideos() {
        if (storage.list().isEmpty()) {
            throw new NoVideoAvailableException();
        } else {
            List<Advertisement> playlist = storage.list();
            Collections.sort(playlist, (o1, o2) -> {
                long l = o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying();
                return (int) (l != 0 ? l : o2.getDuration() - o1.getDuration());
            });

            for (Advertisement video : playlist) {
                playVideo(video);
            }
        }
    }

    /**
     * Консольная имитация показа видео
     * 1 - название ролика,
     * 2- стоимость показа одного рекламного ролика в копейках,
     * 3 - стоимость показа одной секунды рекламного ролика в тысячных частях копейки.
     * @param advertisement Рекламный ролик для воспроизведения.
     */
    private void playVideo(Advertisement advertisement) {
        ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                advertisement.getName(),
                advertisement.getAmountPerOneDisplaying(),
                advertisement.getAmountPerOneDisplaying() * 1000 / advertisement.getDuration()));
    }
}
