package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Connector {
    public static final ResourceBundle resourceBundle = ResourceBundle.getBundle("people");
    public static final String url = resourceBundle.getString("url");
    public static final String user = resourceBundle.getString("user");
    public static final String password = resourceBundle.getString("password");

    public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, user, password);
        }
    }

