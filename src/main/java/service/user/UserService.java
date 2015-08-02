package service.user;

import domain.User;

import java.util.List;

public interface UserService {

    boolean create(User user);

    User read(int id);

    boolean update(int id, String name, String dateOfBirth, String sex, String email, String password);

    void delete(int id);

    List<User> getAll();

    User login(String email, String password);
}
