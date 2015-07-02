package database.system_currency;

import database.currency.Currency;
import database.system.SystemType;

import java.util.List;
/**
 * Created by SpiritMoon
 */
public interface SystemCurrencyDao {
    /** охранить объект SystemCurrency в базе данных */
    void create(SystemType systemType, Currency currency);
    /** Извлечь объек WalletSystem используя id */
    SystemCurrency read(int id);
    /** Внести изменения в SystemCurrency используя id */
    void update(int system_id, int currency_id , int id);
    /** Удалить обхъект SystemCurrency используя id */
    void delete(int id);
    /** Вывести все записи SystemCurrency */
    List<SystemCurrency> getAll();
}
