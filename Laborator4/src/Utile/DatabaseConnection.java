package Utile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/magazin";
    private static final String USER = "root";
    private static final String PASSWORD = "Ursulet1904@";

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conectat la baza de date MySQL!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
