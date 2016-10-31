package ua.yandex.skipass.card;

import ua.yandex.skipass.date.Date;
import static org.junit.Assert.*;
import org.junit.Test;

public class SeasonCardTest {

    @Test
    public void checkCard() {
        SeasonCard card = new SeasonCard(10);
        boolean expRes = card.checkCard(Date.presentDay());
        boolean actRes = true;
        assertEquals(expRes, actRes);
    }
}
