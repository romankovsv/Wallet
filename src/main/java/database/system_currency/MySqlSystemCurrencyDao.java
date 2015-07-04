package database.system_currency;

import org.apache.log4j.Logger;
import database.currency.Currency;
import database.system.SystemType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by SpiritMoon
 */
public class MySqlSystemCurrencyDao implements SystemCurrencyDao {
    public static final Logger log = Logger.getLogger(MySqlSystemCurrencyDao.class);
    private Connection connection;

    @Override
    public void create(SystemType systemType, Currency currency) {
        String sql = "INSERT INTO system_currency (system_id, currency_id) VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, systemType.getId());
            statement.setInt(2, currency.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Error when creating new system-currency dependency", e);
        }
    }

    @Override
    public SystemCurrency read(int id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        SystemCurrency systemCurrency = new SystemCurrency();

        try {
            String sql = "SELECT * FROM system_currency WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            systemCurrency.setId(resultSet.getInt("id"));
            systemCurrency.setCurrencyId(resultSet.getInt("system_id"));
            systemCurrency.setCurrencyId(resultSet.getInt("currency_id"));
        } catch (SQLException e) {
            log.error("Error when reading system-currency dependency", e);
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

        return systemCurrency;
    }

    @Override
    public void update(int system_id, int currency_id , int id) {
        String sql = "UPDATE system_currency SET system_id = ?, currency_id = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, system_id);
            statement.setInt(2, currency_id);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Error when updating system-currency dependency", e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM system_currency WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Error when deleting system-currency dependency", e);
        }
    }

    @Override
    public List<SystemCurrency> getAll() {
        List<SystemCurrency> list = new ArrayList<>();
        String sql = "SELECT * FROM system_currency";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()) {
                SystemCurrency systemCurrency = new SystemCurrency();
                systemCurrency.setId(resultSet.getInt("id"));
                systemCurrency.setSystemId(resultSet.getInt("system_id"));
                systemCurrency.setCurrencyId(resultSet.getInt("currency_id"));
                list.add(systemCurrency);
            }
        } catch (SQLException e) {
            log.error("Error when getting all system-currency dependency", e);
        }

        return list;
    }

    public MySqlSystemCurrencyDao(Connection connection) {
        this.connection = connection;
    }
}
