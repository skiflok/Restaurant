package app.ad;


/**
 * рекламное объявление
 */
public class Advertisement {

    private Object content; // видео
    private String name; //  имя/название
    private long initialAmount; //  Начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    private int hits; //  количество оплаченных показов
    private int duration; //  продолжительность в секундах

    long amountPerOneDisplaying;


    /**
     *
     * @param content видео
     * @param name название
     * @param initialAmount Начальная сумма, стоимость рекламы в копейках
     * @param hits количество оплаченных показов
     * @param duration продолжительность в секундах
     */
    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;

        try {
            amountPerOneDisplaying = initialAmount / hits;
        } catch (ArithmeticException e) {
            amountPerOneDisplaying = 0;
        }
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }
}
