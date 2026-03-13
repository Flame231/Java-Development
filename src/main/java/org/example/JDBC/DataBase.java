package org.example.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataBase {
    public static final Map<Integer, String> map = Map.of(4, "int", 12, "varchar", 91, "date", 93, "dateTime", 92, "time", -1, "text");
    private String sqlQuery;
    List<String> valueList = new ArrayList<>();
    List<String> ColumnNameList = new ArrayList<>();
    int columnCount;

    public DataBase(String sqlQuery) throws SQLException {
        this.sqlQuery = sqlQuery;
    }

    public void getAllResultData() throws SQLException {
        try (Connection connection = Connector.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sqlQuery)) {
            valueList = getValues(resultSet);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            columnCount = resultSetMetaData.getColumnCount();
            ColumnNameList = getColumnNames(resultSetMetaData, columnCount);

        }
    }

    public List<String> getValues(ResultSet resultSet) throws SQLException {
        List<String> list = new ArrayList<>();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        while (resultSet.next()) {
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                list.add(resultSet.getString(i));
            }
        }
        return list;
    }

    public List<String> getColumnNames(ResultSetMetaData resultSetMetaData, int columnCount) throws SQLException {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            list.add(resultSetMetaData.getColumnName(i) + "(" + map.get(resultSetMetaData.getColumnType(i)) + ")");
        }
        return list;
    }

    public List<String> getValueList() {
        return valueList;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public List<String> getColumnNameList() {
        return ColumnNameList;
    }
}








