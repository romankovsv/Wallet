package tables.users;

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
    private Connection connection;

    @Override
    public void create(User user) {
        String sql =
                "INSERT INTO user (name, date_of_birth, date_of_registration, sex, email, password) " +
                        "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getDate_of_birth());
            statement.setDate(3, new Date(System.currentTimeMillis()));
            statement.setString(4, user.getSex());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getPassword());

            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                System.out.println("A new user was created successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User read(int id) {
        User user = new User();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM user WHERE id = ?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setDate_of_birth(resultSet.getString("date_of_birth"));
            user.setDate_of_registration(resultSet.getDate("date_of_registration"));
            user.setSex(resultSet.getString("sex"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    @Override
    public void update(int id) {
        String sql = "UPDATE user SET name = ?, date_of_birth = ?, sex = ?, email = ?, " +
                "password = ?, WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, "New name");
            statement.setString(2, "New date");
            statement.setString(3, "New sex");
            statement.setString(4, "New email");
            statement.setString(5, "New password");
            statement.setInt(6, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM user WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<User>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM user";

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setDate_of_birth(resultSet.getString("date_of_birth"));
                user.setDate_of_registration(resultSet.getDate("date_of_registration"));
                user.setSex(resultSet.getString("sex"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public User login(String email, String password) {
        User user = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setDate_of_birth(resultSet.getString("date_of_birth"));
                user.setDate_of_registration(resultSet.getDate("date_of_registration"));
                user.setSex(resultSet.getString("sex"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    public MySqlUserDao(Connection connection) {
        this.connection = connection;
    }
}
