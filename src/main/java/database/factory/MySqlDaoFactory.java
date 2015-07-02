package database.factory;

import database.currency.CurrencyDao;
import database.currency.MySqlCurrencyDao;
import database.system.MySqlSystemTypeDao;
import database.system.SystemTypeDao;
import database.system_currency.MySqlSystemCurrencyDao;
import database.system_currency.SystemCurrencyDao;
import database.transaction.MySqlHistoryDao;
import database.transaction.HistoryDao;
import database.users.MySqlUserDao;
import database.users.UserDao;
import database.wallets.MySqlWalletDao;
import database.wallets.WalletDao;

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

    public SystemCurrencyDao getSCDao(Connection connection) {
        return new MySqlSystemCurrencyDao(connection);
    }

    public HistoryDao getTransactionDao(Connection connection) {
        return new MySqlHistoryDao(connection);
    }

    public MySqlDaoFactory() {
        try {
            Class.forName(DRIVER); // Регистрация драйвера
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
