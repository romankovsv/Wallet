package service.impl;

import database.currency.Currency;
import database.type.Type;
import database.type_currency.TypeCurrency;
import database.type_currency.TypeCurrencyDao;
import service.ISystemCurrencyService;

import java.util.List;

public class SystemCurrencyService implements ISystemCurrencyService {
    private TypeCurrencyDao typeCurrencyDao;

    @Override
    public void create(Type type, Currency currency) {
        typeCurrencyDao.create(type, currency);
    }

    @Override
    public TypeCurrency read(int id) {
        return typeCurrencyDao.read(id);
    }

    @Override
    public void update(int system_id, int currency_id, int id) {
        typeCurrencyDao.update(system_id, currency_id, id);
    }

    @Override
    public void delete(int id) {
        typeCurrencyDao.delete(id);
    }

    @Override
    public List<TypeCurrency> getAll() {
        return typeCurrencyDao.getAll();
    }
}
