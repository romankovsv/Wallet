package tables.currency;

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
    private Connection connection;

    @Override
    public void create(Currency currency) {
        String sql = "INSERT INTO currency (name) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, currency.getName());

            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                System.out.println("A new tables.currency was created successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Currency read(int id) {
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
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return currency;
    }

    @Override
    public void update(int id) {
        String sql = "UPDATE currency SET name = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, "New Name");
            statement.setInt(2, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing tables.currency was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE * FROM currency WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A tables.currency was deleted successfully!");
            };
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Currency> getAll() {
        List<Currency> list = new ArrayList<Currency>();
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
            e.printStackTrace();
        }

        return list;
    }

    public MySqlCurrencyDao(Connection connection) {
        this.connection = connection;
    }

}
