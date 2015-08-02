package service;

import database.currency.Currency;
import database.system.SystemType;
import database.system_currency.SystemCurrency;

import java.util.List;

public interface ISystemCurrencyService {

    void create(SystemType systemType, Currency currency);

    SystemCurrency read(int id);

    void update(int system_id, int currency_id , int id);

    void delete(int id);

    List<SystemCurrency> getAll();
}
