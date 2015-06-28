package tables.wallets;

import tables.currency.Currency;
import tables.system.SystemType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by SpiritMoon
 */
public class MySqlWalletDao implements WalletDao {
    private Connection connection;

    @Override
    public void create(int userId, int systemId, int currencyId) {
        String sql = "INSERT INTO wallets (users_id, system_id, currency_id) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, userId);
            statement.setInt(2, systemId);
            statement.setInt(3, currencyId);

            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                System.out.println("A new wallet was created successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Wallet> read(int id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Wallet> list = new ArrayList<Wallet>();

        String sql =
                "SELECT w.id, s.name AS 'system.name', c.name AS 'currency.name', w.sum " +
                "FROM wallets w " +
                "JOIN system s ON s.id = w.system_id " +
                "JOIN currency c ON c.id = w.currency_id " +
                "WHERE w.users_id = " + id + "";

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Wallet wallet = new Wallet();
                Currency currency = new Currency();
                SystemType systemType = new SystemType();
                wallet.setId(resultSet.getInt("id"));
                wallet.setSum(resultSet.getInt("w.sum"));

                currency.setName(resultSet.getString("currency.name"));
                        wallet.setCurrency(currency);

                systemType.setName(resultSet.getString("system.name"));
                wallet.setSystemType(systemType);
                list.add(wallet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public void update(int id, int sum) {
        String sql = "UPDATE wallets SET sum = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, sum);
            statement.setInt(2, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing wallet was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM wallets WHERE id = " + id + "";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A wallet was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Wallet> getAll() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Wallet> list = new ArrayList<Wallet>();
        String sql = "SELECT * FROM wallets";

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Wallet wallet = new Wallet();
                wallet.setId(resultSet.getInt("id"));
                wallet.setUserId(resultSet.getInt("users_id"));
                wallet.setSystemId(resultSet.getInt("users_id"));
                wallet.setCurrencyId(resultSet.getInt("users_id"));
                wallet.setSum(resultSet.getInt("sum"));
                list.add(wallet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public void exchange(int idFirst, int idSecond, int sum) {
        PreparedStatement statement = null;
        String sqlFrom = "UPDATE wallets SET sum = sum - " + sum + " WHERE id = " + idFirst + "";
        String sqlTo = "UPDATE wallets SET sum = sum + " + sum + " WHERE id = " + idSecond + "";
        int result;

        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sqlFrom);
            result = statement.executeUpdate();
            if (result == 1) {
                statement = connection.prepareStatement(sqlTo);
                result = statement.executeUpdate();
                if (result == 1) {
                    System.out.println("Exchange complete");
                } else {
                    connection.rollback();
                    throw new SQLException();
                }
            } else {
                connection.rollback();
                throw new SQLException();
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void fillUp(int id, int sum) {
        PreparedStatement statement = null;
        String sql = "UPDATE wallets SET sum = sum + " + sum + " WHERE id = " + id + "";
        int result;

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeUpdate();

            if (result == 1) {
                System.out.println("The sum is update");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public MySqlWalletDao(Connection connection) { this.connection = connection; }
}
