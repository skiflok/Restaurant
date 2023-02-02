package app.kitchen;

public enum Dish {
    FISH,
    STEAK,
    SOUP,
    JUICE,
    WATER;

    public static String allDishesToString() {
        String res = "";
        for (Dish dish: Dish.values()) {
            if ("".equals(res)) {
                res = dish.name();
            } else {
                res += ", " + dish.name();
            }

        }

        return res;
    }
}
