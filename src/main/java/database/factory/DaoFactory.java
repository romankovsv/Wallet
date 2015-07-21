package database.factory;
/**
 * Created by SpiritMoon
 */
import database.currency.CurrencyDao;
import database.system.SystemTypeDao;
import database.system_currency.SystemCurrencyDao;
import database.history.HistoryDao;
import database.users.UserDao;
import database.wallets.WalletDao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
/** Фабрика объектов для работы с базой данных */
public interface DaoFactory {
    /** Возвращает подключение к базе данных */
    Connection getConnection() throws SQLException, IOException;

    /** Возвращает объект для работы с состоянием user */
    UserDao getUserDao(Connection connection);

    /** Возвращает объект для работы с состоянием wallets */
    WalletDao getWalletDao(Connection connection);

    /** Возвращает объект для работы с состоянием currency */
    CurrencyDao getCurrencyDao(Connection connection);

    /** Возвращает объект для работы с состоянием system */
    SystemTypeDao getSystemTypeDao(Connection connection);

    /** Возвращает объект для работы с состоянием system_currency */
    SystemCurrencyDao getSCDao(Connection connection);

    /** Возвращает объект для работы с состоянием history */
    HistoryDao getTransactionDao(Connection connection);
}
