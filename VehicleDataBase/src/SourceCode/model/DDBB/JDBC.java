package SourceCode.model.DDBB;

import java.sql.*;

public class JDBC {

    final private String ddbbUrl =
            "jdbc:mysql://ualq7jtsbrkdloq0:BnnGdxXPbnp9MPo4cMke@brl9tb8g3nimmtuxx8xa-mysql.services.clever-cloud.com:3306/brl9tb8g3nimmtuxx8xa";
    final private String userName = "ualq7jtsbrkdloq0";
    final private String password = "BnnGdxXPbnp9MPo4cMke";
    private Connection connection;

    public JDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = getConnection();

        } catch (ClassNotFoundException ec) {
            ec.printStackTrace();
        } catch (SQLException es) {
            es.printStackTrace();
        }
    }

    public ResultSet executeQuery(String SqlInput) throws SQLException {
        Statement sentence = connection.createStatement();
        ResultSet resultSet = sentence.executeQuery(SqlInput);

        return resultSet;
    }

    public void executeUpdate(String SqlInput) throws SQLException {
        Statement sentence = connection.createStatement();
        sentence.executeUpdate(SqlInput);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(ddbbUrl, userName, password);

        return connection;
    }

}
