package ua.yandex.skipass.date;

import static org.junit.Assert.*;
import org.junit.Test;

public class DateTest {

    @Test
    public void compareToBefore() {
        Date date1 = new Date(2015, 1, 4, 10);
        Date date2 = new Date(2015, 1, 5, 10);
        int expRes = date2.compareTo(date1);
        int actRes = 24;
        assertEquals(expRes, actRes);
    }

    @Test
    public void compareToAfter() {
        Date date1 = new Date(2015, 1, 4, 10);
        Date date2 = new Date(2015, 1, 5, 20);
        int expRes = date1.compareTo(date2);
        int actRes = -34;
        assertEquals(expRes, actRes);
    }

    @Test
    public void isWeekendTrue() {
        Date date = new Date(2015, 1, 4, 10);
        boolean expRes = date.isWeekend();
        boolean actRes = true;
        assertEquals(actRes, expRes);
    }

    @Test
    public void isWeekendFalse() {
        Date date = new Date(2015, 1, 6, 10);
        boolean expRes = date.isWeekend();
        boolean actRes = false;
        assertEquals(actRes, expRes);
    }

    @Test
    public void dateOfWeek() {
        Date date = new Date(2015, 1, 4, 10);
        int expRes = date.dateOfWeek();
        int actRes = 0;
        assertEquals(expRes, actRes);
    }

    @Test
    public void dateOfWeekWorkDay() {
        Date date = new Date(2015, 1, 8, 10);
        int expRes = date.dateOfWeek();
        int actRes = 4;
        assertEquals(expRes, actRes);
    }

    @Test
    public void presentDay() {
        Date expRes = Date.presentDay();
        Date actRes = new Date(2015, 1, 6, 5);
        int actual = expRes.compareTo(actRes);
        assertEquals(0, actual);
    }

    @Test
    public void getHour() {
        Date date = new Date(2015, 1, 6, 14);
        int expRes = date.getHour();
        int actRes = 14;
        assertEquals(actRes, expRes);
    }
}
