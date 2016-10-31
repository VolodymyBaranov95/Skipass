package ua.yandex.skipass.card;

import ua.yandex.skipass.date.Date;

public class WorkDayCardForTime extends WorkDayCard {

    private TimeCard time;
    private Date date;

    public WorkDayCardForTime(int id, TimeCard time, Date date) {
        super(id);
        this.time = time;
        this.date = date;
    }

    @Override
    public boolean checkCard(Date current) {
        return super.checkCard(current) && checkTime(current);
    }

    public boolean checkTime(Date currentDate) {
        if (time.equals(TimeCard.FIRSTHALFDAY)) {
            if (currentDate.getHour() > 13 || currentDate.getHour() < 9) {
                return false;
            }
        }
        if (time.equals(TimeCard.SECONDHALFDAY)) {
            if (currentDate.getHour() < 13 || currentDate.getHour() > 17) {
                return false;
            }
        }
        int delta = date.compareTo(currentDate);
        if (delta < 0 || delta >= this.time.getTime()) {
            return false;
        } else {
            return true;
        }
    }

    public TimeCard getTime() {
        return time;
    }

    public Date getDate() {
        return date;
    }
}
