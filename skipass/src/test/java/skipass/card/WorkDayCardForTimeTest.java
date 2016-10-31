package ua.yandex.skipass.card;

import ua.yandex.skipass.date.Date;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class WorkDayCardForTimeTest {

    @Test
    public void checkTimeCardSingleCall() {
        WorkDayCardForTime card = mock(WorkDayCardForTime.class);
        Date date = new Date(0, 0, 0, 0);
        card.checkCard(date);
        verify(card).checkCard(date);
    }

    @Test
    public void repeatedlyCheckTime() {
        WorkDayCardForTime card = mock(WorkDayCardForTime.class);
        Date date1 = mock(Date.class);
        Date date2 = mock(Date.class);
        Date date3 = mock(Date.class);
        card.checkTime(date1);
        card.checkTime(date2);
        card.checkTime(date2);
        verify(card, times(1)).checkTime(date1);
        verify(card, times(2)).checkTime(date2);
        verify(card, never()).checkTime(date3);
    }

    @Test
    public void checkCardSingleCall() {
        WorkDayCardForTime card = mock(WorkDayCardForTime.class);
        Date date = mock(Date.class);
        card.checkCard(date);
        verify(card).checkCard(date);
    }

    @Test
    public void checkCardRepeatedlyCall() {
        WorkDayCardForTime card = mock(WorkDayCardForTime.class);
        Date date1 = mock(Date.class);
        Date date2 = mock(Date.class);
        Date date3 = mock(Date.class);
        card.checkCard(date1);
        card.checkCard(date2);
        card.checkCard(date2);
        verify(card, times(1)).checkCard(date1);
        verify(card, times(2)).checkCard(date2);
        verify(card, never()).checkCard(date3);
    }

    @Test
    public void checkTimeAllowableDifference() {
        int deltaHour = 3;
        Date date1 = mock(Date.class);
        Date date2 = mock(Date.class);
        TimeCard time = TimeCard.FIRSTHALFDAY;
        WorkDayCardForTime card = new WorkDayCardForTime(1, time, date1);
        when(date1.compareTo(date2)).thenReturn(deltaHour);
        assertFalse(card.checkTime(date2));
    }

    @Test
    public void checkTimeNotrAllowableDifference() {
        int deltaHour = -100;
        Date date1 = mock(Date.class);
        Date date2 = mock(Date.class);
        TimeCard time = TimeCard.SECONDHALFDAY;
        WorkDayCardForTime card = new WorkDayCardForTime(1, time, date1);
        when(date1.compareTo(date2)).thenReturn(deltaHour);
        assertFalse(card.checkTime(date2));
    }

    @Test
    public void checkTimeForOneDayCardAllowableDifference() {
        int deltaHour = 20;
        Date date1 = mock(Date.class);
        Date date2 = mock(Date.class);
        TimeCard time = TimeCard.ONEDAY;
        WorkDayCardForTime card = new WorkDayCardForTime(1, time, date1);
        when(date1.compareTo(date2)).thenReturn(deltaHour);
        assertTrue(card.checkTime(date2));
    }

    @Test
    public void checkTimeForOneDayCardNotAllowableDifference() {
        int deltaHour = 25;
        Date date1 = mock(Date.class);
        Date date2 = mock(Date.class);
        TimeCard time = TimeCard.ONEDAY;
        WorkDayCardForTime card = new WorkDayCardForTime(1, time, date1);
        when(date1.compareTo(date2)).thenReturn(deltaHour);
        assertFalse(card.checkTime(date2));
    }

    @Test
    public void checkTimeForTwoDaysCardAllowableDifference() {
        int deltaHour = 50;
        Date date1 = mock(Date.class);
        Date date2 = mock(Date.class);
        TimeCard time = TimeCard.TWODAYS;
        WorkDayCardForTime card = new WorkDayCardForTime(1, time, date1);
        when(date1.compareTo(date2)).thenReturn(deltaHour);
        assertFalse(card.checkTime(date2));
    }

    @Test
    public void checkTimeForTwoDaysCardNotAllowableDifference() {
        int deltaHour = 47;
        Date date1 = mock(Date.class);
        Date date2 = mock(Date.class);
        TimeCard time = TimeCard.TWODAYS;
        WorkDayCardForTime card = new WorkDayCardForTime(1, time, date1);
        when(date1.compareTo(date2)).thenReturn(deltaHour);
        assertTrue(card.checkTime(date2));
    }

    @Test
    public void checkTimeForFiveDaysCardNotAllowableDifference() {
        int deltaHour = 125;
        Date date1 = mock(Date.class);
        Date date2 = mock(Date.class);
        TimeCard time = TimeCard.FIVEDAYS;
        WorkDayCardForTime card = new WorkDayCardForTime(1, time, date1);
        when(date1.compareTo(date2)).thenReturn(deltaHour);
        assertFalse(card.checkTime(date2));
    }

    @Test
    public void checkTimeForFiveCardsAllowableDifference() {
        int deltaHour = 118;
        Date date1 = mock(Date.class);
        Date date2 = mock(Date.class);
        TimeCard time = TimeCard.FIVEDAYS;
        WorkDayCardForTime card = new WorkDayCardForTime(1, time, date1);
        when(date1.compareTo(date2)).thenReturn(deltaHour);
        assertTrue(card.checkTime(date2));
    }

    @Test
    public void checkCardForFiveDaysCardNotWeekend() {
        Date currentDate = new Date(2015, 1, 6, 10);
        Date spy = spy(currentDate);
        Date date = new Date(2015, 1, 6, 20);
        TimeCard time = TimeCard.FIVEDAYS;
        WorkDayCardForTime card = new WorkDayCardForTime(1, time, date);
        when(spy.isWeekend()).thenReturn(true);
        assertFalse(card.checkCard(spy));
    }

    @Test
    public void checkCardForFiveDaysCardWeekend() {
        Date currentDate = new Date(2015, 1, 6, 10);
        Date spy = spy(currentDate);
        Date date = new Date(2015, 1, 6, 20);
        TimeCard time = TimeCard.FIVEDAYS;
        WorkDayCardForTime card = new WorkDayCardForTime(1, time, date);
        when(spy.isWeekend()).thenReturn(false);
        assertTrue(card.checkCard(spy));
    }

    @Test
    public void checkCardForOneDayCardWeekendNotAllowableDifferrense() {
        Date date = new Date(2015, 1, 4, 20);
        Date currenDate = new Date(2015, 1, 6, 20);
        Date spy = spy(currenDate);
        TimeCard time = TimeCard.FIRSTHALFDAY;
        WeekendCardForTime card = new WeekendCardForTime(1, time, date);
        when(spy.isWeekend()).thenReturn(true);
        assertFalse(card.checkCard(spy));
    }

    @Test
    public void checkCardForTwoDaysCardWeekendNotAllowableDifferrense() {
        Date date = new Date(2015, 1, 3, 20);
        Date currenDate = new Date(2015, 1, 6, 20);
        Date spy = spy(currenDate);
        TimeCard time = TimeCard.SECONDHALFDAY;
        WorkDayCardForTime card = new WorkDayCardForTime(1, time, date);
        when(spy.isWeekend()).thenReturn(true);
        assertFalse(card.checkCard(spy));
    }

    @Test
    public void checkCardForTwoDaysCardNotWeekend() {
        Date currentDate = new Date(2015, 1, 6, 10);
        Date spy = spy(currentDate);
        Date date = new Date(2015, 1, 6, 20);
        TimeCard time = TimeCard.TWODAYS;
        WorkDayCardForTime card = new WorkDayCardForTime(1, time, date);
        when(spy.isWeekend()).thenReturn(true);
        assertFalse(card.checkCard(spy));
    }

    @Test
    public void checkCardForFisrtHalfCardNotWeekend() {
        Date currentDate = new Date(2015, 1, 6, 10);
        Date spy = spy(currentDate);
        Date date = new Date(2015, 1, 6, 11);
        TimeCard time = TimeCard.FIRSTHALFDAY;
        WorkDayCardForTime card = new WorkDayCardForTime(1, time, date);
        when(spy.isWeekend()).thenReturn(true);
        assertFalse(card.checkCard(spy));
    }

    @Test
    public void checkCardForFisrtHalfDayCardNotAllowableDif() {
        Date currentDate = new Date(2015, 1, 6, 10);
        Date spy = spy(currentDate);
        Date date = new Date(2015, 1, 6, 15);
        TimeCard time = TimeCard.FIRSTHALFDAY;
        WorkDayCardForTime card = new WorkDayCardForTime(1, time, date);
        when(spy.isWeekend()).thenReturn(true);
        assertFalse(card.checkCard(spy));
    }

    @Test
    public void getDateTest() {
        Date currentDate = new Date(2015, 1, 6, 10);
        TimeCard time = TimeCard.FIRSTHALFDAY;
        WorkDayCardForTime card = new WorkDayCardForTime(1, time, currentDate);
        Date expDate = card.getDate();
        assertTrue(expDate.compareTo(currentDate) == 0);
    }

    @Test
    public void getTimeTest() {
        Date currentDate = new Date(2015, 1, 6, 10);
        TimeCard time = TimeCard.FIRSTHALFDAY;
        WorkDayCardForTime card = new WorkDayCardForTime(1, time, currentDate);
        TimeCard actTime = card.getTime();
        assertTrue(actTime.ordinal() == time.ordinal());
    }
}
