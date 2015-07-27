package service;

import database.users.User;

import java.util.List;
/**
 * Created by SpiritMoon
 */
public interface IUserService {
    /** Сохранить объект User в базе данных */
    boolean create(User user);
    /** Извлечь объек User используя указанный id в качестве первичного ключа */
    User read(int id);
    /** Внести изменения в User */
    boolean update(int id, String name, String dateOfBirth, String sex, String email, String password);
    /** Удалить объект User */
    void delete(int id);
    /** Вывод всех записей по User */
    List<User> getAll();
    /** Аутентификация пользователя */
    User login(String email, String password);
}
