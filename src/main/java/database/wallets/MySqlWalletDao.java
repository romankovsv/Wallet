package database.wallets;

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
public class MySqlWalletDao implements WalletDao {
    private static final Logger log = Logger.getLogger(MySqlWalletDao.class);
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
                log.info("A new wallet was created successfully!");
            }
        } catch (SQLException e) {
           log.error(e);
        }
    }

    @Override
    public List<Wallet> readByUserId(int id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Wallet> list = new ArrayList<>();

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
            log.error(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                log.error(e);
            }
        }

        return list;
    }

    @Override
    public void update(int id, int sum) {

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM wallets WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowDeleted = statement.executeUpdate();
            if (rowDeleted > 0) {
                log.info("A wallet was deleted successfully!");
            }
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public void deleteUserWallets(int id) {
        String sql = "DELETE FROM wallets WHERE 'user_id' = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowsDelete = statement.executeUpdate();
            if (rowsDelete > 0) {
                log.info("All wallets were deleted successfully!");
            }
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public List<Wallet> getAll() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Wallet> list = new ArrayList<>();
        String sql = "SELECT * FROM wallets";

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Wallet wallet = new Wallet();
                wallet.setId(resultSet.getInt("id"));
                wallet.setUserId(resultSet.getInt("users_id"));
                wallet.setSystemId(resultSet.getInt("system_id"));
                wallet.setCurrencyId(resultSet.getInt("currency_id"));
                wallet.setSum(resultSet.getInt("sum"));
                list.add(wallet);
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public void exchange(int idFirst, int idSecond, int sum) {
        PreparedStatement statement = null;
        String sqlFrom = "UPDATE wallets SET sum = sum - ? WHERE id = ?";
        String sqlTo = "UPDATE wallets SET sum = sum + ? WHERE id = ?";
        int result;

        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sqlFrom);
            statement.setInt(1, sum);
            statement.setInt(2, idFirst);
            result = statement.executeUpdate();
            if (result == 1) {
                statement = connection.prepareStatement(sqlTo);
                statement.setInt(1, sum);
                statement.setInt(2, idSecond);
                result = statement.executeUpdate();
                if (result == 1) {
                    log.info("Exchange complete");
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
            log.error(e);
        } finally {
            try {
                connection.setAutoCommit(true);
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void changeBalance(int id, int sum) {
        PreparedStatement statement = null;
        String sql = "UPDATE wallets SET sum = sum + ? WHERE id = ?";
        int result;

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sum);
            statement.setInt(2, id);
            result = statement.executeUpdate();

            if (result == 1) {
                log.info("The sum is update");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                log.error(e);
            }
        }
    }

    public Wallet readByWalletId(int id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM wallets WHERE id = ?";
        Wallet wallet = new Wallet();

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                wallet.setId(resultSet.getInt("id"));
                wallet.setUserId(resultSet.getInt("users_id"));
                wallet.setSystemId(resultSet.getInt("system_id"));
                wallet.setCurrencyId(resultSet.getInt("currency_id"));
                wallet.setSum(resultSet.getInt("sum"));
            }
        } catch (SQLException e) {
            log.error(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                log.error(e);
            }
        }

        return wallet;
    }

    public MySqlWalletDao(Connection connection) { this.connection = connection; }
}
