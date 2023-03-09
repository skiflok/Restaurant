package app.kitchen;

public enum Dish {
    FISH(25),
    STEAK(30),
    SOUP(15),
    JUICE(5),
    WATER(3),
    NOT_HUNGRY(1);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString() {
        String res = "";
        for (Dish dish : Dish.values()) {
            if ("".equals(res)) {
                res = dish.name();
            } else {
                res += ", " + dish.name();
            }

        }

        return res;
    }
}
