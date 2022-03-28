package by.belstu.zvarykin;

import DAO.DAOConnectionManager;
import DAO.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    static final Logger logger = LogManager.getLogger(DAOConnectionManager.class);

    public static void main(String[] args) throws SQLException {
        var manager = new DAOConnectionManager();
        var connection = manager.Connect();
        var requests = new Request(connection);

        requests.req1();
        requests.req2();
        requests.req3("Tesla");
        requests.req5("Тимофей Хованский", "FREE ROBUX");
        manager.Disconnect(connection);


    }
}

