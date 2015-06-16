package tables.factory;
/**
 * Created by SpiritMoon
 */
import tables.currency.CurrencyDao;
import tables.system.SystemTypeDao;
import tables.system_currency.SystemCurrencyDao;
import tables.users.UserDao;
import tables.wallet_system.WalletSystemDao;
import tables.wallets.WalletDao;

import java.sql.Connection;
import java.sql.SQLException;
/** Фабрика объектов для работы с базой данных */
public interface DaoFactory {
    /** Возвращает подключение к базе данных */
    public Connection getConnection() throws SQLException;

    /** Возвращает объект для работы с состоянием user */
    public UserDao getUserDao(Connection connection);

    /** Возвращает объект для работы с состоянием wallets */
    public WalletDao getWalletDao(Connection connection);

    /** Возвращает объект для работы с состоянием currency */
    public CurrencyDao getCurrencyDao(Connection connection);

    /** Возвращает объект для работы с состоянием system */
    public SystemTypeDao getSystemTypeDao(Connection connection);

    /** Возвращает объект для работы с состоянием system_currency */
    public SystemCurrencyDao getS_CDao(Connection connection);

    /** Возвращает объект для работы с состоянием wallets_system */
    public WalletSystemDao getW_SDao(Connection connection);
}
