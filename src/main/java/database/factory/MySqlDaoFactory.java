package database.factory;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * Created by SpiritMoon
 */
public class MySqlDaoFactory implements DaoFactory {
    private static final Logger log = Logger.getLogger(MySqlDaoFactory.class);

    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;
    private static String DRIVER;

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public MySqlDaoFactory() {
        loadProperties();
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            log.error("Error when registering MySQL driver", e);
        }
    }

    private void loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(MySqlDaoFactory.class.getResourceAsStream("/db.properties"));
            URL = properties.getProperty("url");
            USERNAME = properties.getProperty("username");
            PASSWORD = properties.getProperty("password");
            DRIVER = properties.getProperty("driver");
        } catch (IOException e) {
            log.error("Can't read file", e);
        }
    }
}
