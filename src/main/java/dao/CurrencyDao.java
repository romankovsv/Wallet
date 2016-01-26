package dao;

import domain.Currency;

import java.util.List;

public interface CurrencyDao {

    void create(Currency currency);

    Currency readById(int id);

    void updateById(int id, String name);

    void deleteById(int id);

    List<Currency> getAll();
}
