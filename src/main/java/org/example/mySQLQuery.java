package org.example;

import com.sun.source.tree.StatementTree;

import java.sql.*;
import java.util.Map;
import java.util.ResourceBundle;

public class mySQLQuery {
    public static void main(String[] args) throws SQLException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("people");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");

        String query = "select * from person where age > 21 order by dateTimeCreate";

        ResultSet resultSet = getConnection(url, user, password, query);
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        int number = resultSetMetaData.getColumnCount();

        printTableMetaData(resultSetMetaData, number);
        System.out.println();
        printTableData(resultSet, number);
    }

    private static ResultSet getConnection(String url, String user, String password, String query) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)
        ) {
            return resultSet;
        }
    }

    private static void printTableData(ResultSet resultSet, int number) throws SQLException {
        while (resultSet.next()) {
            for (int i = 1; i <= number; i++)
                System.out.print(resultSet.getString(i) + "\t\t\t\t");
            System.out.println();
        }
    }

    private static void printTableMetaData(ResultSetMetaData resultSetMetaData, int number) throws SQLException {
        System.out.println(resultSetMetaData.getTableName(1));
        for (int i = 1; i <= number; i++) {
            int type = resultSetMetaData.getColumnType(i);
            Map<Integer, String> map = Map.of(4, "int", 12, "varchar", 91, "date", 93, "dateTime", 92, "time", -1, "text");
            System.out.print(resultSetMetaData.getColumnName(i) +
                    "(" + map.get(resultSetMetaData.getColumnType(i)) + ")" + "\t\t");
        }
    }
}
