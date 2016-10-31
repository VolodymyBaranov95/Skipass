package ua.yandex.skipass.card;

import ua.yandex.skipass.date.Date;

public class WorkDayCardForTripsNumber extends WorkDayCard {

    private NumberCard trips;
    private int tripCount;

    public WorkDayCardForTripsNumber(int id, NumberCard trips) {
        super(id);
        this.tripCount = trips.getTripCount();
    }

    @Override
    public boolean checkCard(Date current) {
        return super.checkCard(current) && this.checkTripCounts();
    }

    public boolean checkTripCounts() {
        if (tripCount <= 0) {
            return false;
        } else {
            tripCount--;
            return true;
        }
    }
}
