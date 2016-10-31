package ua.yandex.skipass.date;

public class Date {

    int year;
    int month;
    int day;
    int hour;

    public Date(int year, int month, int date, int hour) {
        this.year = year;
        this.month = month;
        this.day = date;
        this.hour = hour;
    }

    public int compareTo(Date otherDate) {
        int deltaHours = this.hour - otherDate.hour;
        int deltaDay = (this.day - otherDate.day) * 24;
        int deltaMonth = (this.month - otherDate.month) * 24 * 30;
        int deltaYear = (this.year - otherDate.year) * 24 * 30 * 12;
        return deltaHours + deltaDay + deltaMonth + deltaYear;
    }

    public boolean isWeekend() {
        int tempRes = dateOfWeek();
        if (tempRes == 6 || tempRes == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int dateOfWeek() {
        int a, y, m, r;
        a = (14 - this.month) / 12;
        y = this.year - a;
        m = this.month + 12 * a - 2;
        r = 7000 + (this.day + y + y / 4 - y / 100 + y / 400 + (31 * m) / 12);
        return r % 7;
    }
    public int getHour(){
        return hour;
    }

    public static Date presentDay() {
        return new Date(2015, 1, 6, 5);
    }
}
