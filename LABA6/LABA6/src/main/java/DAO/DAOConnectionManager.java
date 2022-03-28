package DAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOConnectionManager {
    static final Logger logger = LogManager.getLogger(DAOConnectionManager.class);

    public java.sql.Connection Connect() {
        java.sql.Connection conn = null;

        try {

            String dbURL = "jdbc:sqlserver://localhost:1434;databaseName=JABA;integratedSecurity=true;"
                    + "encrypt=true;trustServerCertificate=true";

            conn = DriverManager.getConnection(dbURL);
            logger.info("ESTABLISHED CONNECTION WITH MSSQL");


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;

    }

    public void Disconnect(java.sql.Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        logger.info("Disconnected from mssql");

    }


}
