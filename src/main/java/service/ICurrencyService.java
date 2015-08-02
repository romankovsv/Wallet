package service;

import database.currency.Currency;

import java.util.List;

public interface ICurrencyService {

    void create(Currency currency);

    Currency read(int id);

    void update(int id, String name);

    void delete(int id);

    List<Currency> getAll();
}
