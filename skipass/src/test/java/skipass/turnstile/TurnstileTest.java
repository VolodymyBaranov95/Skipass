package ua.yandex.skipass.turnstile;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import ua.yandex.skipass.card.Card;
import ua.yandex.skipass.date.Date;
import ua.yandex.skipass.system.CardType;
import ua.yandex.skipass.system.Systema;
import static org.mockito.Mockito.*;

public class TurnstileTest {

    @Test
    public void checkCardTestTrue() {
        Systema systema = new Systema();
        Turnstile turnstile = new Turnstile(systema);
        Card card = systema.releaseCard(CardType.WORKDAYTRIPS,
                1, new Date(2015, 1, 6, 15), "TEN");
        boolean expRes = turnstile.checkCard(card);
        assertTrue(expRes);
    }

    @Test
    public void checkCardFalse() {
        Systema systema = new Systema();
        Turnstile turnstile = new Turnstile(systema);
        Card card = systema.releaseCard(CardType.WEEKENDTRIPS,
                1, new Date(2015, 1, 6, 15), "TEN");
        boolean expRes = systema.checkCard(card);
        assertFalse(expRes);
    }

    @Test
    public void checkCardWithMockTrue() {
        Systema systema = mock(Systema.class);
        Card card = mock(Card.class);
        Turnstile turnstile = new Turnstile(systema);
        when(systema.checkCard(card)).thenReturn(true);
        boolean expRes = turnstile.checkCard(card);
        assertTrue(expRes);
    }
}
