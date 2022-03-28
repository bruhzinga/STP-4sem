package by.beltsu.Zvorykin;

import by.beltsu.Zvorykin.Administrator.Administrator;
import com.google.gson.Gson;
import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;

import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;


public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class);

    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }

    public static void main(String[] args) {
        try {
            var Mycards = new ArrayList<Card>();
            Mycards.add(new Card(false, 1000, 1337, 228));
            Mycards.add(new Card(false, 2000, 7331, 133));
            var randCard = new Card(false, 10000, 1111, 1111);
            var Dzmitry = new Client(new Account("Dzmitry", "123123РБ7А"), Mycards);
            var apitest = Mycards.stream().filter(x->x.getBalance()>5000).toList();
            Client.LOG.info("Initiated new Client instance");
            Dzmitry.BlockCard(Mycards.get(1));
            Card.LOG.info(Mycards.get(1).isBlocked() + " card is blocked");
            // Dzmitry.BlockCard(randCard);
            Client.LOG.info(Dzmitry.ShowBalance(Mycards.get(0)) + " = balance");
            Dzmitry.Transaction(Client.transactionType.Pay, 100, Mycards.get(0));
            Client.LOG.info("transaction:pay");
            Client.LOG.info(Dzmitry.ShowBalance(Mycards.get(0)) + " = balance");
            Dzmitry.Transaction(Client.transactionType.AddMoney, 500, Mycards.get(0));
            Client.LOG.info("transaction:add");
            Client.LOG.info(Dzmitry.ShowBalance(Mycards.get(0)) + " = balance");

            var Admin = new Administrator();
            Admin.BlockCard(randCard);
            Card.LOG.info(randCard.isBlocked() + " card is blocked");
            if (Admin.SearchBy(Mycards, Administrator.searchContext.ByCardNumber, 1337) != null) {
                Administrator.LOG.info("Card found");
            } else {
                Administrator.LOG.info("Card not found");
            }
            Gson gson = new Gson();
            BufferedWriter writer = new BufferedWriter(new FileWriter("Object.json"));
            writer.write(gson.toJson(Dzmitry));
            writer.close();


            var encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("MyList.xml")));

            encoder.writeObject(Dzmitry);
            encoder.close();


        } catch (RuntimeException | IOException e) {
            LOG.error(e.getMessage());
        }


    }
}
