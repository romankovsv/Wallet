package service.currency;

import domain.Currency;

import java.util.List;

public interface CurrencyService {

    void create(Currency currency);

    Currency read(int id);

    void update(int id, String name);

    void delete(int id);

    List<Currency> getAll();
}
