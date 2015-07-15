package database.currency;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by SpiritMoon
 */
public class MySqlCurrencyDao implements CurrencyDao {
    private static final Logger log = Logger.getLogger(MySqlCurrencyDao.class);
    private Connection connection;

    @Override
    public void create(Currency currency) {
        String sql = "INSERT INTO currency (name) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, currency.getName());

            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                log.info("A new currency was created successfully!");
            }
        } catch (SQLException e) {
            log.error("Error when creating new user", e);
        }
    }

    @Override
    public Currency readById(int id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Currency currency = new Currency();
        String sql = "SELECT * FROM currency WHERE id = ?";

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            resultSet.next();
            currency.setId(resultSet.getInt("id"));
            currency.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            log.error("Error when reading user data", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                log.error("Error when closing resources", e);
            }
        }

        return currency;
    }

    @Override
    public void updateById(int id, String name) {
        String sql = "UPDATE currency SET name = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, name);
            statement.setInt(2, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                log.info("An existing database.currency was updated successfully!");
            }
        } catch (SQLException e) {
            log.error("Error when updating user data", e);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE * FROM currency WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                log.info("A database.currency was deleted successfully!");
            }
        } catch (SQLException e) {
            log.error("Error when deleting user", e);
        }
    }

    @Override
    public List<Currency> getAll() {
        List<Currency> list = new ArrayList<>();
        String sql = "SELECT * FROM currency";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Currency currency = new Currency();
                currency.setId(resultSet.getInt("id"));
                currency.setName(resultSet.getString("name"));
                list.add(currency);
            }
        } catch (SQLException e) {
            log.error("Error when getting all users", e);
        }

        return list;
    }

    public MySqlCurrencyDao(Connection connection) {
        this.connection = connection;
    }

}
