package service.impl;

import database.currency.Currency;
import database.currency.CurrencyDao;
import service.ICurrencyService;

import java.util.List;

public class CurrencyService implements ICurrencyService {
    private CurrencyDao currencyDao;

    @Override
    public void create(Currency currency) {
        currencyDao.create(currency);
    }

    @Override
    public Currency read(int id) {
        return currencyDao.readById(id);
    }

    @Override
    public void update(int id, String name) {
        currencyDao.updateById(id, name);
    }

    @Override
    public void delete(int id) {
        currencyDao.deleteById(id);
    }

    @Override
    public List<Currency> getAll() {
        return currencyDao.getAll();
    }

    public void setCurrencyDao(CurrencyDao currencyDao) {
        this.currencyDao = currencyDao;
    }
}
