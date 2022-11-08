package SourceCode.model.DDBB;

import java.sql.*;
import java.util.Vector;

public class JDBC {

    final private String ddbbUrl =
            "jdbc:mysql://uvgto96abljwfbvz:cJO3hPgkUoq2OKpiMiCL@bvbwsath5b4vnterq76i-mysql.services.clever-cloud.com:3306/bvbwsath5b4vnterq76i";
    final private String userName = "uvgto96abljwfbvz";
    final private String password = "cJO3hPgkUoq2OKpiMiCL";
    final private String schemaName = "bvbwsath5b4vnterq76i";
    private Connection connection;

    private DatabaseMetaData dbmd;

    public JDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = getConnection();
            dbmd=connection.getMetaData();

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

    public String[] GetTableNames() throws SQLException {
        Vector<String> tableNames = new Vector<>();
        ResultSet resul = dbmd.getTables(schemaName, null, null, null);

        while (resul.next()) {
            tableNames.add(resul.getString("TABLE_NAME"));
        }

        String[] names = new String[tableNames.size()];
        for (int i=0;i<names.length;i++) {
            names[i] = tableNames.get(i);
        }

        return names;
    }

    public String[] GetColumnNames(String tableName) throws SQLException {
        Vector<String> columnNames = new Vector<>();
        ResultSet columns=dbmd.getColumns(null,schemaName,tableName, null);

        while (columns.next()) {
            columnNames.add(columns.getString("COLUMN_NAME"));
        }

        String[] names = new String[columnNames.size()];
        for (int i=0;i<names.length;i++) {
            names[i] = columnNames.get(i);
        }

        return names;
    }

}
