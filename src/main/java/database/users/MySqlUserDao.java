package database.users;

import database.factory.MySqlDaoFactory;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
/**
 * Created by SpiritMoon
 */
public class MySqlUserDao implements UserDao {
    private static final Logger log = Logger.getLogger(MySqlUserDao.class);
    private MySqlDaoFactory daoFactory = new MySqlDaoFactory();

    @Override
    public boolean create(User user) {
        boolean result = false;
        String sql =
                "INSERT INTO user (name, date_of_birth, date_of_registration, sex, email, password) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getDateOfBirth());
            statement.setDate(3, new Date(System.currentTimeMillis()));
            statement.setString(4, user.getSex());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getPassword());

            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                log.info("A new user was created successfully!");
                result = true;
            }
        } catch (SQLException e) {
            log.error("Error when creating new user", e);
        }

        return result;
    }

    @Override
    public User read(int id) {
        User user = new User();
        String sql = "SELECT * FROM user WHERE id = ?";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setDateOfBirth(resultSet.getString("date_of_birth"));
            user.setDateOfRegistration(resultSet.getDate("date_of_registration"));
            user.setSex(resultSet.getString("sex"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
        } catch (SQLException e) {
            log.error("Error when reading user's data", e);
        }

        return user;
    }

    @Override
    public boolean update(int id, String name, String dateOfBirth, String sex, String email, String password) {
        String sql = "UPDATE user SET name = ?, date_of_birth = ?, sex = ?, email = ?, " +
                "password = ? WHERE id = ?";
        boolean result = false;

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, dateOfBirth);
            statement.setString(3, sex);
            statement.setString(4, email);
            statement.setString(5, password);
            statement.setInt(6, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                log.info("An existing user was updated successfully!");
                result = true;
            }
        } catch (SQLException e) {
            log.error("Error when updateById user data", e);
        }

        return result;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM user WHERE id = ?";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                log.info("A user was deleted successfully!");
            }
        } catch (SQLException e) {
            log.error("Error when deleteById user", e);
        }
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM user";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setDateOfBirth(resultSet.getString("date_of_birth"));
                user.setDateOfRegistration(resultSet.getDate("date_of_registration"));
                user.setSex(resultSet.getString("sex"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                list.add(user);
            }
        } catch (SQLException e) {
            log.error("Error when getting all users", e);
        }

        return list;
    }

    public User login(String email, String password) {
        User user = null;
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setDateOfBirth(resultSet.getString("date_of_birth"));
                user.setDateOfRegistration(resultSet.getDate("date_of_registration"));
                user.setSex(resultSet.getString("sex"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            log.error("Login error", e);
        }

        return user;
    }

}
