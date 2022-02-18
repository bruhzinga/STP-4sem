package by.beltsu.Zvorykin.Administrator;

import by.beltsu.Zvorykin.CanBlock;
import by.beltsu.Zvorykin.Card;
import org.apache.log4j.Logger;

import java.util.List;

public class Administrator implements CanBlock {
    public static final Logger LOG = Logger.getLogger(Administrator.class);

    public void BlockCard(Card card) {
        card.setBlocked(true);

    }

    public Card SearchBy(List<Card> cards, searchContext context, int search) {
        if (context == searchContext.ByBalance) {
            for (var card : cards
            ) {
                if (card.getBalance() == search) {
                    return card;
                }
            }
        } else {
            for (var card : cards
            ) {
                if (card.getCardNumber() == search) {
                    return card;
                }
            }


        }
        return null;
    }


    public Card CreateNewCard(Card card) {
        return card;
    }

    public enum searchContext {ByBalance, ByCardNumber}


}
