package ua.yandex.skipass.card;

import ua.yandex.skipass.date.Date;

abstract public class WeekendCard extends Card {

    public WeekendCard(int id) {
        super(id);
    }

    @Override
    public boolean checkCard(Date date) {
        return date.isWeekend();
    }
}
