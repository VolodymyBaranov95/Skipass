package ua.yandex.skipass.system;

import ua.yandex.skipass.collections.MyArrayList;
import ua.yandex.skipass.card.*;
import java.util.*;
import ua.yandex.skipass.date.Date;

public class Systema {

    private MyArrayList baseOfCard;
    private MyArrayList blockedCard;
    private int[] statReleaseCards;
    private int countAllowedPassage;
    private int countNotAllowedPassage;

    public Systema() {
        this.baseOfCard = new MyArrayList();
        this.blockedCard = new MyArrayList();
        this.statReleaseCards = new int[100];
        countAllowedPassage = 0;
        countNotAllowedPassage = 0;
    }
//для типа карточки вызываю valueOf чтобы определить точное количество дней или
// поездок - передаем точный тип карточки;

    public Card releaseCard(CardType cardtype, int id, Date date,
            String exactCardType) {
        Card result = null;

        switch (cardtype) {
            case WEEKENDTIME:
                result = new WeekendCardForTime(id,
                        TimeCard.valueOf(exactCardType), date);
                break;
            case WEEKENDTRIPS:
                result = new WeekendCardForTripsNumber(id,
                        NumberCard.valueOf(
                                exactCardType));
                break;
            case WORKDAYTIME:
                result = new WorkDayCardForTime(id,
                        TimeCard.valueOf(exactCardType), date);
                break;
            case WORKDAYTRIPS:
                result = new WorkDayCardForTripsNumber(id,
                        NumberCard.valueOf(
                                exactCardType));
                break;
            case SEASON:
                result = new SeasonCard(id);
                break;
            default:
                throw new NotEnoughCardException();
        }
        baseOfCard.add(id);
        statReleaseCards[cardtype.ordinal()]++;
        return result;
    }

    public void blockCard(Card card) {
        blockedCard.add(card.getId());
    }

    public boolean checkCard(Card card) {
        if ((card.checkCard(Date.presentDay())
                && blockedCard.indexOf(card.getId()) == -1)) {
            countAllowedPassage++;
            return true;
        } else {
            countNotAllowedPassage++;
            return false;
        }
    }

    public boolean isBlocked(Card card) {
        return this.blockedCard.indexOf(card.getId()) != -1;
    }

    public int getAllowedPassage() {
        return this.countAllowedPassage;
    }

    public int getNotAlowedPassage() {
        return this.countNotAllowedPassage;
    }

    public int getReleaseCardByType(CardType cardtype) {
        return statReleaseCards[cardtype.ordinal()];
    }

}
