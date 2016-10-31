package ua.yandex.skipass.turnstile;

import ua.yandex.skipass.card.*;
import ua.yandex.skipass.system.Systema;

public class Turnstile {

    private Systema systema;

    public Turnstile(Systema systema) {
        this.systema = systema;
    }

    public boolean checkCard(Card card) {
        return systema.checkCard(card);
    }
}
