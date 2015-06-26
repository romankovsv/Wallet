package tables.factory;

import tables.currency.CurrencyDao;
import tables.currency.MySqlCurrencyDao;
import tables.system.MySqlSystemTypeDao;
import tables.system.SystemTypeDao;
import tables.system_currency.MySqlSystemCurrencyDao;
import tables.system_currency.SystemCurrencyDao;
import tables.users.MySqlUserDao;
import tables.users.UserDao;
import tables.wallets.MySqlWalletDao;
import tables.wallets.WalletDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Created by SpiritMoon
 */
public class MySqlDaoFactory implements DaoFactory {
    private final static String URL = "jdbc:mysql://localhost:3306/exchange service"; // URL адресс
    private final static String USERNAME = "root"; // Имя пользователя
    private final static String PASSWORD = "root"; // Пароль
    private final static String DRIVER = "com.mysql.jdbc.Driver"; // Имя драйвера

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public UserDao getUserDao(Connection connection) {
        return new MySqlUserDao(connection);
    }

    public WalletDao getWalletDao(Connection connection) {
        return new MySqlWalletDao(connection);
    }

    public CurrencyDao getCurrencyDao(Connection connection) {
        return new MySqlCurrencyDao(connection);
    }

    public SystemTypeDao getSystemTypeDao(Connection connection) {
        return new MySqlSystemTypeDao(connection);
    }

    public SystemCurrencyDao getS_CDao(Connection connection) {
        return new MySqlSystemCurrencyDao(connection);
    }

    public MySqlDaoFactory() {
        try {
            Class.forName(DRIVER); // Регистрация драйвера
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
