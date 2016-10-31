package ua.yandex.skipass.card;

import ua.yandex.skipass.date.Date;

public abstract class Card {

    public abstract boolean checkCard(Date current);

    protected int id;

    protected Card(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
