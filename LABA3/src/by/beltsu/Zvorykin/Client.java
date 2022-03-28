package by.beltsu.Zvorykin;

import org.apache.log4j.Logger;

import java.util.List;

public class Client implements CanBlock {
    public static final Logger LOG = Logger.getLogger(Client.class);

    public Client(Account account, List<Card> cards) {
        this.account = account;
        this.cards = cards;
    }
    public  Client()
    {


    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    Account account;

    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public int ShowBalance(Card card) {
        if (!cards.contains(card)) {
            throw new RuntimeException("CARD DOES NOT BELONG TO YOU");
        }
       return (card.getBalance());


    }

    public void BlockCard(Card card) {
        if (!cards.contains(card)) {
            throw new RuntimeException("CARD DOES NOT BELONG TO YOU");

        }
        card.setBlocked(true);

    }

    public void Transaction(transactionType type, int sum,Card card) {
        if (!cards.contains(card)) {
            throw new RuntimeException("CARD DOES NOT BELONG TO YOU");
        }


        if (type == transactionType.Pay){
            card.setBalance(card.getBalance()-sum);

        }
        else
        {
            card.setBalance(card.getBalance()+sum);
        }


    }

    enum transactionType {Pay, AddMoney}


}


