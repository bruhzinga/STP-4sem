package by.beltsu.Zvorykin;

import org.apache.log4j.Logger;

public class Card
{
    public Card()
    {

    }

    public static final Logger LOG = Logger.getLogger(Card.class);
    private boolean isBlocked;

    public Card(boolean isBlocked, int balance, int cardNumber, int PIN) {
        this.isBlocked = isBlocked;
        Balance = balance;
        CardNumber = cardNumber;
        this.PIN = PIN;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    private int Balance;



    public int getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(int cardNumber) {
        CardNumber = cardNumber;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    private int CardNumber;
    private int PIN;


    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
