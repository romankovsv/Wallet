package dao.currency;

import dao.factory.MySqlDaoFactory;
import domain.Currency;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlCurrencyDao implements CurrencyDao {
    private static final Logger log = Logger.getLogger(MySqlCurrencyDao.class);
    private MySqlDaoFactory daoFactory = new MySqlDaoFactory();

    @Override
    public void create(Currency currency) {
        log.info("Create new currency");
        String sql = "INSERT INTO currency (name) VALUES (?)";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, currency.getName());

            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                log.info("A new currency was created successfully!");
            }
        } catch (SQLException e) {
            log.error("Error when creating new currency", e);
        }
    }

    @Override
    public Currency readById(int id) {
        log.info("Read currency");
        Currency currency = new Currency();
        String sql = "SELECT * FROM currency WHERE id = ?";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            currency.setId(resultSet.getInt("id"));
            currency.setName(resultSet.getString("name"));
        } catch (SQLException e) {
            log.error("Error when reading currency data", e);
        }

        return currency;
    }

    @Override
    public void updateById(int id, String name) {
        log.info("Update currency");
        String sql = "UPDATE currency SET name = ? WHERE id = ?";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                log.info("An existing currency was updated successfully!");
            }
        } catch (SQLException e) {
            log.error("Error when updating currency data", e);
        }
    }

    @Override
    public void deleteById(int id) {
        log.info("Delete currency");
        String sql = "DELETE * FROM currency WHERE id = ?";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                log.info("A currency was deleted successfully!");
            }
        } catch (SQLException e) {
            log.error("Error when deleting currency", e);
        }
    }

    @Override
    public List<Currency> getAll() {
        log.info("Get all currency");
        List<Currency> list = new ArrayList<>();
        String sql = "SELECT * FROM currency";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Currency currency = new Currency();
                currency.setId(resultSet.getInt("id"));
                currency.setName(resultSet.getString("name"));
                list.add(currency);
            }
        } catch (SQLException e) {
            log.error("Error when getting all currency", e);
        }

        return list;
    }

}
