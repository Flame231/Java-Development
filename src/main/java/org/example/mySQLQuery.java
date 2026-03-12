package org.example;

import java.sql.*;
import java.util.Map;

public class mySQLQuery {
    public static final String sqlQuery = "select * from person where age > 21 order by dateTimeCreate";
    public static final Map<Integer, String> map = Map.of(4, "int", 12, "varchar", 91, "date", 93, "dateTime", 92, "time", -1, "text");
    public static final String fourTabulations = "\t\t\t\t";
    public static final String twoTabulations = "\t\t";
    public static void main(String[] args) throws SQLException {

        DataBase dataBase = new DataBase(sqlQuery);
        dataBase.getAllResultData();
        ResultSet resultSet = dataBase.getResultSet();
        ResultSetMetaData resultSetMetaData = dataBase.getResultSetMetaData();
        int columnNumber = dataBase.Count();

            printTableMetaData(resultSetMetaData, columnNumber);
            System.out.println();
            printTableData(resultSet, columnNumber);

    }



    private static void printTableData(ResultSet resultSet, int number) throws SQLException {
        while (resultSet.next()) {
            for (int i = 1; i <= number; i++) {
                System.out.print(resultSet.getString(i) + fourTabulations);
            }
            System.out.println();
        }
    }

    private static void printTableMetaData(ResultSetMetaData resultSetMetaData, int number) throws SQLException {
        System.out.println(resultSetMetaData.getTableName(1));
        for (int i = 1; i <= number; i++) {
            int type = resultSetMetaData.getColumnType(i);
            System.out.print(resultSetMetaData.getColumnName(i) +
                    "(" + map.get(resultSetMetaData.getColumnType(i)) + ")" + twoTabulations);
        }
    }
}
