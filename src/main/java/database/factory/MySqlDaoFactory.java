package database.factory;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Created by SpiritMoon
 */
public class MySqlDaoFactory implements DaoFactory {
    private static final Logger log = Logger.getLogger(MySqlDaoFactory.class);

    private final static String URL = "jdbc:mysql://localhost:3306/exchange service";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";
    private final static String DRIVER = "com.mysql.jdbc.Driver";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public MySqlDaoFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            log.error("Error when registering MySQL driver", e);
        }
    }
}
