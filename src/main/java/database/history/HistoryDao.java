package database.history;

import java.util.List;
/**
 * Created by SpiritMoon
 */
public interface HistoryDao {
    /** Сохранить объект History в базе данных */
    void create(History history);
    /** Извлечь все записи по User.id учавствующих в транзакции */
    List<History> readByUserId(int id);
    /** Удалить объект History по id */
    void deleteById(int id);
    /** Вывод всех записей по History */
    List<History> getAll();
}
