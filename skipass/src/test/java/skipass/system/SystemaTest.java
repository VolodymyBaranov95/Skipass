package ua.yandex.skipass.system;

import ua.yandex.skipass.card.*;
import ua.yandex.skipass.date.Date;
import static org.junit.Assert.*;
import org.junit.Test;

public class SystemaTest {

    @Test
    public void releaseCardTestCheckCardType() {
        Systema systema = new Systema();
        Card card = systema.releaseCard(CardType.WORKDAYTIME,
                1, new Date(2015, 1, 6, 15), "ONEDAY");
        WorkDayCardForTime presentCard = (WorkDayCardForTime) card;
        TimeCard presentTime = presentCard.getTime();
        assertEquals(presentTime, TimeCard.ONEDAY);
    }

    @Test
    public void releaseCardTestCheckDate() {
        Systema systema = new Systema();
        Card card = systema.releaseCard(CardType.WORKDAYTIME,
                1, new Date(2015, 1, 6, 15), "TWODAYS");
        WorkDayCardForTime presentCard = (WorkDayCardForTime) card;
        Date date = presentCard.getDate();
        assertTrue(date.compareTo(new Date(2015, 1, 6, 15)) == 0);
    }

    @Test
    public void releaseCardTestCheckCardTypeTripsCard() {
        Systema systema = new Systema();
        Card card = systema.releaseCard(CardType.WEEKENDTRIPS,
                1, new Date(2015, 1, 6, 15), "TEN");
        WeekendCardForTripsNumber presentCard = (WeekendCardForTripsNumber) card;
        NumberCard presentNumber = presentCard.getTrips();
        assertEquals(presentNumber, NumberCard.TEN);
    }

    @Test
    public void releaseCardTestCheckStat() {
        Systema systema = new Systema();
        Card card = systema.releaseCard(CardType.WEEKENDTRIPS,
                1, new Date(2015, 1, 6, 15), "TEN");
        assertTrue(systema.getReleaseCardByType(
                CardType.WEEKENDTRIPS) == 1);
    }

    @Test
    public void blockCard() {
        Systema systema = new Systema();
        Card card = systema.releaseCard(CardType.WEEKENDTRIPS,
                1, new Date(2015, 1, 1, 15), "TEN");
        systema.blockCard(card);
        boolean expRes = systema.isBlocked(card);
        assertTrue(expRes);
    }

    @Test
    public void checkCardWorkDayTrips() {
        Systema systema = new Systema();
        Card card = systema.releaseCard(CardType.WORKDAYTRIPS,
                1, new Date(2015, 1, 6, 15), "TEN");
        boolean expRes = systema.checkCard(card);
        assertTrue(expRes);
    }

    @Test
    public void checkCardWeekendTrips() {
        Systema systema = new Systema();
        Card card = systema.releaseCard(CardType.WEEKENDTRIPS,
                1, new Date(2015, 1, 6, 15), "TEN");
        boolean expRes = systema.checkCard(card);
        assertFalse(expRes);
    }

    @Test
    public void checkCardWeekendTime() {
        Systema systema = new Systema();
        Card card = systema.releaseCard(CardType.WEEKENDTIME,
                1, new Date(2015, 1, 6, 15), "ONEDAY");
        boolean expRes = systema.checkCard(card);
        assertFalse(expRes);
    }

    @Test
    public void checkCardWeekendDayTime() {
        Systema systema = new Systema();
        Card card = systema.releaseCard(CardType.WORKDAYTRIPS,
                1, new Date(2015, 1, 6, 8), "FIFTY");
        boolean expRes = systema.checkCard(card);
        assertTrue(systema.checkCard(card));
    }

    @Test
    public void isBlockedTest() {
        Systema systema = new Systema();
        Card card = systema.releaseCard(CardType.WORKDAYTRIPS,
                1, new Date(2015, 1, 6, 8), "FIFTY");
        systema.blockCard(card);
        systema.releaseCard(CardType.WORKDAYTIME, 12,
                Date.presentDay(), "ONEDAY");
        boolean expRes = systema.isBlocked(card);
        assertTrue(expRes);
    }

    @Test
    public void getAllowedTest() {
        Systema systema = new Systema();
        Card card = systema.releaseCard(CardType.WORKDAYTRIPS,
                1, new Date(2015, 1, 6, 8), "FIFTY");
        Card card1 = systema.releaseCard(CardType.WEEKENDTIME,
                1, new Date(2015, 1, 6, 15), "ONEDAY");
        systema.checkCard(card);
        systema.checkCard(card1);
        assertEquals(1, systema.getAllowedPassage());
    }

    @Test
    public void getNotAllowedTest() {
        Systema systema = new Systema();
        Card card = systema.releaseCard(CardType.WORKDAYTRIPS,
                1, new Date(2015, 1, 6, 8), "FIFTY");
        Card card1 = systema.releaseCard(CardType.WEEKENDTIME,
                1, new Date(2015, 1, 6, 15), "ONEDAY");
        systema.checkCard(card);
        systema.checkCard(card1);
        assertEquals(1, systema.getNotAlowedPassage());
    }

    @Test
    public void getReleaseCardByTypeTest() {
        Systema systema = new Systema();
        Card card = systema.releaseCard(CardType.WORKDAYTRIPS,
                1, new Date(2015, 1, 6, 8), "FIFTY");
        Card card1 = systema.releaseCard(CardType.WORKDAYTRIPS,
                2, new Date(2015, 1, 6, 8), "FIFTY");
        Card card2 = systema.releaseCard(CardType.WORKDAYTRIPS,
                3, new Date(2015, 1, 6, 8), "FIFTY");
        int expRes = systema.getReleaseCardByType(
                CardType.WORKDAYTRIPS);
        assertEquals(expRes, 3);
    }
}
