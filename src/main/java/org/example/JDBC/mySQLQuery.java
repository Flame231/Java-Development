package org.example.JDBC;

import java.sql.*;
import java.util.Iterator;
import java.util.List;

public class mySQLQuery {
    public static final String sqlQuery = "select * from person where age > 21 order by dateTimeCreate";

    public static void main(String[] args) throws SQLException {
        DataBase dataBase = new DataBase(sqlQuery);
        dataBase.getAllResultData();
        printData(dataBase.getColumnNameList(), dataBase.getColumnCount());
        printData(dataBase.getValueList(), dataBase.getColumnCount());
    }

    private static void printData(List<String> list, int countColumn) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            for (int i = 1; i <= countColumn; i++) {
                String format = "%-25s";
                System.out.printf(format, iterator.next());
            }
            System.out.println();

        }
    }
}