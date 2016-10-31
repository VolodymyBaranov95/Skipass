package ua.yandex.skipass.card;

public enum NumberCard {

    TEN(10), TWENTY(20), FIFTY(50), ONEHUNDRED(100);

    private final int count;

    private NumberCard(int trips) {
        this.count = trips;
    }

    public int getTripCount() {
        return count;
    }

}
