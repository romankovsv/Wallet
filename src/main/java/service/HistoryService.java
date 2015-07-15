package service;

import database.history.History;

import java.util.List;
/**
 * Created by SpiritMoon
 */
public interface HistoryService {
    /** Сохранить объект History в базе данных */
    void create(History history);
    /** Извлечь все записи по User.id учавствующих в транзакции */
    List<History> read(int id);
    /** Внести изменения в History по id */
    void update(int id);
    /** Удалить объект History по id */
    void delete(int id);
    /** Вывод всех записей по History */
    List<History> getAll();
}
