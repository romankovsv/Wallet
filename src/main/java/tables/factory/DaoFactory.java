package tables.factory;
/**
 * Created by SpiritMoon
 */
import tables.currency.CurrencyDao;
import tables.system.SystemTypeDao;
import tables.system_currency.SystemCurrencyDao;
import tables.users.UserDao;
import tables.wallets.WalletDao;

import java.sql.Connection;
import java.sql.SQLException;
/** Фабрика объектов для работы с базой данных */
public interface DaoFactory {
    /** Возвращает подключение к базе данных */
    Connection getConnection() throws SQLException;

    /** Возвращает объект для работы с состоянием user */
    UserDao getUserDao(Connection connection);

    /** Возвращает объект для работы с состоянием wallets */
    WalletDao getWalletDao(Connection connection);

    /** Возвращает объект для работы с состоянием currency */
    CurrencyDao getCurrencyDao(Connection connection);

    /** Возвращает объект для работы с состоянием system */
    SystemTypeDao getSystemTypeDao(Connection connection);

    /** Возвращает объект для работы с состоянием system_currency */
    SystemCurrencyDao getS_CDao(Connection connection);
}
