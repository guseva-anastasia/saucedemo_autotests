package models;

public enum Categories {
    MILK_EGGS ("\n" +
            "                                Молочные продукты, яйцо\n" +
            "                            "),
    CHEESE("\n" +
            "                                Сыры\n" +
            "                            "),
    VEGETABLES_AND_FRUITS ("Овощи, фрукты");

    public final String description;

    Categories(String description) {
        this.description = description;
    }
}
