package ua.yandex.skipass.card;

import ua.yandex.skipass.date.Date;

abstract public class WorkDayCard extends Card {

    public WorkDayCard(int id) {
        super(id);
    }

    @Override
    public boolean checkCard(Date current) {
        return !current.isWeekend();
    }
}
