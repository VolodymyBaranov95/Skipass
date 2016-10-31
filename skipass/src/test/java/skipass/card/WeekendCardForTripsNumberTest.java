package ua.yandex.skipass.card;

import ua.yandex.skipass.date.Date;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class WeekendCardForTripsNumberTest {

    @Test
    public void checkCardSingleCall() {
        WeekendCardForTripsNumber card = mock(WeekendCardForTripsNumber.class);
        Date date = new Date(0, 0, 0, 0);
        card.checkCard(date);
        verify(card).checkCard(date);
    }

    @Test
    public void repeatedlyCheckTripsCount() {
        WeekendCardForTripsNumber card = mock(WeekendCardForTripsNumber.class);
        card.checkTripCounts();
        card.checkTripCounts();
        card.checkTripCounts();
        verify(card, times(3)).checkTripCounts();
    }

    @Test
    public void checkCardRepeatedlyCall() {
        WeekendCardForTripsNumber card = mock(WeekendCardForTripsNumber.class);
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
    public void checkTripCountsToSkip() {
        NumberCard tripCounts = NumberCard.TEN;
        WeekendCardForTripsNumber card
                = new WeekendCardForTripsNumber(1, tripCounts);
        boolean expRes = card.checkTripCounts();
        boolean actRes = true;
        assertEquals(expRes, actRes);
    }

    @Test
    public void checkTripCountsToCount() {
        NumberCard tripCounts = NumberCard.TEN;
        WeekendCardForTripsNumber card
                = new WeekendCardForTripsNumber(1, tripCounts);
        for (int i = 0; i < 10; i++) {
            card.checkTripCounts();
        }
        boolean expRes = card.checkTripCounts();
        boolean actRes = false;
        assertEquals(expRes, actRes);
    }

    @Test
    public void checkCardWorkday() {
        NumberCard tripCounts = NumberCard.TWENTY;
        WeekendCardForTripsNumber card
                = new WeekendCardForTripsNumber(1, tripCounts);
        Date date = mock(Date.class);
        when(date.isWeekend()).thenReturn(true);
        assertTrue(card.checkCard(date));
    }

    @Test
    public void checkCardWeekendDay() {
        NumberCard tripCounts = NumberCard.TWENTY;
        WeekendCardForTripsNumber card
                = new WeekendCardForTripsNumber(1, tripCounts);
        Date date = mock(Date.class);
        when(date.isWeekend()).thenReturn(false);
        assertFalse(card.checkCard(date));
    }

    @Test
    public void getTripsTest() {
        NumberCard tripCounts = NumberCard.FIFTY;
        WeekendCardForTripsNumber card
                = new WeekendCardForTripsNumber(1, tripCounts);
        NumberCard trips = NumberCard.FIFTY;
        assertEquals(trips,card.getTrips());
    }
    @Test
    public void checkCardTest(){
        NumberCard tripCounts = NumberCard.FIFTY;
        WeekendCardForTripsNumber card
                = new WeekendCardForTripsNumber(1, tripCounts);
        assertTrue(card.checkCard(new Date(2015,1,3,3)));
    }
}
