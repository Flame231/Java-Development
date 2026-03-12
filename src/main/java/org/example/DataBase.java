package org.example;

import java.sql.*;

public class DataBase {

    private int columnCount;
    private String sqlQuery;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;
    private Connection connection = Connector.getConnection();
    private Statement statement = connection.createStatement();

    public DataBase(String sqlQuery) throws SQLException {
        this.sqlQuery = sqlQuery;
    }

    public void getAllResultData() throws SQLException {
        resultSet = statement.executeQuery(sqlQuery);
        resultSetMetaData = resultSet.getMetaData();
        columnCount = resultSetMetaData.getColumnCount();
    }

    public ResultSet getResultSet() throws SQLException {
        return resultSet;
    }

    public ResultSetMetaData getResultSetMetaData() throws SQLException {
        return resultSetMetaData;
    }

    public int Count() throws SQLException {
        return columnCount;
    }
}
