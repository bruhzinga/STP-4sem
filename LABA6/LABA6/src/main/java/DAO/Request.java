package DAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Request {
    Connection con = null;
    static final Logger logger = LogManager.getLogger(Request.class);

    public Request(Connection con) {
        this.con = con;
    }

    public ResultSet SendRequest(String strSql) {
        try {
            var query = con.createStatement();
            ResultSet rs = query.executeQuery(strSql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void req1() throws SQLException {
        var rs = SendRequest("select top(1) [Отправитель] from Letters ORDER by len([Текст Письма])");
        while (rs.next()) {
            System.out.println(rs.getString("Отправитель"));

        }
        System.out.println();
        logger.info("SQl request one done");
    }

    public void req2() throws SQLException {
        var str = "select distinct [ФИО], [Дата Рождения],\n" +
                "    count(ФИО) OVER (PARTITION by ФИО) AS [КОЛ-ВО ПИСЕМ]\n" +
                "from People join Letters\n" +
                "    ON People.ФИО = Letters.Отправитель";
        var rs = SendRequest(str);
        while (rs.next()) {
            System.out.println(rs.getString("ФИО") + " " + rs.getString("Дата Рождения") + " " + rs.getInt("КОЛ-ВО ПИСЕМ"));

        }
        System.out.println();
        logger.info("SQl request two done");


    }

    public void req3(String tema) throws SQLException {
        var str = "select distinct [ФИО], [Дата Рождения]\n" +
                "from People join Letters\n" +
                "    ON People.ФИО = Letters.Отправитель\n" +
                "WHERE Letters.[Тема Письма]=?";
        var st = con.prepareStatement(str);
        st.setString(1, tema);
        var rs = st.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("ФИО") + " " + rs.getString("Дата Рождения"));

        }
        System.out.println();
        logger.info("SQl request three done");

    }

    public void req4(String tema) throws SQLException {
        var str = "select distinct [ФИО], [Дата Рождения]\n" +
                "from People join Letters\n" +
                "    ON People.ФИО = Letters.Отправитель\n" +
                "WHERE NOT Letters.[Тема Письма]=?";
        var st = con.prepareStatement(str);
        st.setString(1, tema);
        var rs = st.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("ФИО") + " " + rs.getString("Дата Рождения"));

        }
        System.out.println();
        logger.info("SQl request four done");


    }

    public void req5(String Name, String Tema) throws SQLException {
        var allNames = new ArrayList<String>();
        var rs = SendRequest("SELECT [ФИО] from People");
        while (rs.next()) {
            allNames.add(rs.getString("ФИО"));
        }
        var st = con.prepareStatement("insert into Letters VALUES(?, ?, ?, ?, '2022-05-21')");

        for (var name : allNames) {
            st.setString(1, Name);
            st.setString(2, name);
            st.setString(3, Tema);
            st.setString(4, "SPAM MESSAGE");
            st.executeUpdate();

        }
        logger.info("SQl request five done");

    }

}
