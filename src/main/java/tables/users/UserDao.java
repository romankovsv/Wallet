package tables.users;

import java.util.List;
/**
 * Created by SpiritMoon
 */
public interface UserDao {
    /** Сохранить объект User в базе данных */
    void create(User user);
    /** Извлечь объек User используя указанный id в качестве первичного ключа */
    User read(int id);
    /** Внести изменения в User */
    void update(int id);
    /** Удалить объект User */
    void delete(int id);
    /** Вывод всех записей по User */
    List<User> getAll();
    /** Аутентификация пользователя */
    User login(String email, String password);
}
