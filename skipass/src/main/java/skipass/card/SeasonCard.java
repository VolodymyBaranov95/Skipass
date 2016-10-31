package ua.yandex.skipass.card;

import ua.yandex.skipass.date.Date;

public class SeasonCard extends Card {

    public SeasonCard(int id) {
        super(id);
    }

    @Override
    public boolean checkCard(Date date) {
        return true;
    }
}
