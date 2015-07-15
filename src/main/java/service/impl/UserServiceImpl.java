package service.impl;

import database.users.User;
import database.users.UserDao;
import service.UserService;

import java.util.List;
/**
 * Created by SpiritMoon
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public boolean create(User user) {
        boolean createUser = userDao.create(user);
        return createUser;
    }

    @Override
    public User read(int id) {
        return null;
    }

    @Override
    public boolean update(int id, String name, String dateOfBirth, String sex, String email, String password) {
        boolean updateUser = userDao.update(id, name, dateOfBirth, sex, email, password);
        return updateUser;
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User login(String email, String password) {
        return userDao.login(email, password);
    }
}
