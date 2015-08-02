package dao.type_currency;

import domain.Currency;
import domain.Type;
import domain.TypeCurrency;

import java.util.List;

public interface TypeCurrencyDao {

    void create(Type type, Currency currency);

    TypeCurrency read(int id);

    void update(int system_id, int currency_id , int id);

    void delete(int id);

    List<TypeCurrency> getAll();
}
