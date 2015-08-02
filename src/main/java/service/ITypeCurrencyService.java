package service;

import database.currency.Currency;
import database.type.Type;
import database.type_currency.TypeCurrency;

import java.util.List;

public interface ITypeCurrencyService {

    void create(Type type, Currency currency);

    TypeCurrency read(int id);

    void update(int system_id, int currency_id , int id);

    void delete(int id);

    List<TypeCurrency> getAll();
}
