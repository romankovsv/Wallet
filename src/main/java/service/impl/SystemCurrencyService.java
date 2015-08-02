package service.impl;

import database.currency.Currency;
import database.system.SystemType;
import database.system_currency.SystemCurrency;
import database.system_currency.SystemCurrencyDao;
import service.ISystemCurrencyService;

import java.util.List;

public class SystemCurrencyService implements ISystemCurrencyService {
    private SystemCurrencyDao systemCurrencyDao;

    @Override
    public void create(SystemType systemType, Currency currency) {
        systemCurrencyDao.create(systemType, currency);
    }

    @Override
    public SystemCurrency read(int id) {
        return systemCurrencyDao.read(id);
    }

    @Override
    public void update(int system_id, int currency_id, int id) {
        systemCurrencyDao.update(system_id, currency_id, id);
    }

    @Override
    public void delete(int id) {
        systemCurrencyDao.delete(id);
    }

    @Override
    public List<SystemCurrency> getAll() {
        return systemCurrencyDao.getAll();
    }
}
