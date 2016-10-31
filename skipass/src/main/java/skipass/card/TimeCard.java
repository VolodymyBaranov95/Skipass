package ua.yandex.skipass.card;

public enum TimeCard {

    FIRSTHALFDAY(4), SECONDHALFDAY(4), ONEDAY(24), TWODAYS(48),
    FIVEDAYS(120);

    private final int hours;

    private TimeCard(int hours) {
        this.hours = hours;
    }

    public int getTime() {
        return hours;

    }
}
