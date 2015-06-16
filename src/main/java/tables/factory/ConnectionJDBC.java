package tables.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Created by SpiritMoon
 */
public class ConnectionJDBC {
    private Connection connection;
    private final static String URL = "jdbc:mysql://localhost:3306/exchange service"; // URL адресс
    private final static String USERNAME = "root"; // Имя пользователя
    private final static String PASSWORD = "root"; // Пароль

    public ConnectionJDBC() {

    }

    public void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
