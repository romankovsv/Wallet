package tables.transaction;

import java.util.List;
/**
 * Created by SpiritMoon
 */
public interface HistoryDao {
    /** Сохранить объект Transaction в базе данных */
    void create(History history);
    /** Извлечь все записи по User.id учавствующих в транзакции */
    List<History> read(int id);
    /** Внести изменения в Transaction по id */
    void update(int id);
    /** Удалить объект Transaction по id */
    void delete(int id);
    /** Вывод всех записей по Transaction */
    List<History> getAll();
}
