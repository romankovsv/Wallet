package database.currency;

import java.util.List;
/**
 * Created by SpiritMoon
 */
public interface CurrencyDao {
    /** Сохранить объект Currency в базе данных */
    void create(Currency currency);
    /** Извлечь объек Currency используя указанный id в качестве первичного ключа */
    Currency readById(int id);
    /** Внести изменения в Currency по ID */
    void updateById(int id, String name);
    /** Удалить объект Currency по ID */
    void deleteById(int id);
    /** Вывод всех записей по Currency */
    List<Currency> getAll();
}
