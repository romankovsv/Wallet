package tables.system;

import java.util.List;
/**
 * Created by SpiritMoon
 */
public interface SystemTypeDao {
    /** Сохранить объект System в базе данных */
    void create(SystemType systemType);
    /** Извлечь объек System используя указанный id в качестве первичного ключа */
    SystemType read(int id);
    /** Внести изменения в System */
    void update(int id);
    /** Удалить объект System */
    void delete(int id);
    /** Вывод всех записей по System */
    List<SystemType> getAll();
}
