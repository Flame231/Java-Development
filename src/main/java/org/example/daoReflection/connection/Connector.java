package org.example.daoReflection.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Connector {

    public static Connection getConnection() throws SQLException {
        final ResourceBundle resourceBundle = ResourceBundle.getBundle("people");
        final String url = resourceBundle.getString("url");
        final String user = resourceBundle.getString("user");
        final String password = resourceBundle.getString("password");
        return DriverManager.getConnection(url,user,password);
    }

}
