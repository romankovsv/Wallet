package dao.wallets;

import dao.factory.MySqlDaoFactory;
import domain.Wallet;
import org.apache.log4j.Logger;
import domain.Currency;
import domain.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlWalletDao implements WalletDao {
    private static final Logger log = Logger.getLogger(MySqlWalletDao.class);
    private MySqlDaoFactory daoFactory = new MySqlDaoFactory();

    @Override
    public void createForUserById(int userId, int systemId, int currencyId) {
        log.info("Create new wallet");
        String sql = "INSERT INTO wallets (users_id, type_id, currency_id) VALUES (?, ?, ?)";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setInt(2, systemId);
            statement.setInt(3, currencyId);

            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                log.info("A new wallet was created successfully!");
            }
        } catch (SQLException e) {
            log.error("Error when creating new wallet", e);
        }
    }

    @Override
    public List<Wallet> readForUserById(int id) {
        log.info("Read user's wallet");
        List<Wallet> list = new ArrayList<>();

        String sql =
                "SELECT w.id, t.name AS 'type.name', c.name AS 'currency.name', w.sum " +
                "FROM wallets w " +
                "JOIN type t ON t.id = w.type_id " +
                "JOIN currency c ON c.id = w.currency_id " +
                "WHERE w.users_id = ?";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Wallet wallet = new Wallet();
                Currency currency = new Currency();
                Type type = new Type();
                wallet.setId(resultSet.getInt("id"));
                wallet.setSum(resultSet.getInt("w.sum"));

                currency.setName(resultSet.getString("currency.name"));
                wallet.setCurrency(currency);

                type.setName(resultSet.getString("type.name"));
                wallet.setType(type);
                list.add(wallet);
            }
        } catch (SQLException e) {
            log.error("Error when reading user's wallets", e);
        }

        return list;
    }

    @Override
    public void deleteById(int id) {
        log.info("Delete wallet");
        String sql = "DELETE FROM wallets WHERE id = ?";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowDeleted = statement.executeUpdate();
            if (rowDeleted > 0) {
                log.info("A wallet was deleted successfully!");
            }
        } catch (SQLException e) {
            log.error("Error when deleting current wallet", e);
        }
    }

    @Override
    public void deleteUserWalletById(int id) {
        log.info("Delete user's wallet");
        String sql = "DELETE FROM wallets WHERE 'user_id' = ?";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowsDelete = statement.executeUpdate();
            if (rowsDelete > 0) {
                log.info("All wallets were deleted successfully!");
            }
        } catch (SQLException e) {
            log.error("Error when deleting user's wallet", e);
        }
    }

    @Override
    public List<Wallet> getAll() {
        log.info("Get all wallet");
        List<Wallet> list = new ArrayList<>();
        String sql = "SELECT * FROM wallets";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Wallet wallet = new Wallet();
                wallet.setId(resultSet.getInt("id"));
                wallet.setUserId(resultSet.getInt("users_id"));
                wallet.setSystemId(resultSet.getInt("type_id"));
                wallet.setCurrencyId(resultSet.getInt("currency_id"));
                wallet.setSum(resultSet.getInt("sum"));
                list.add(wallet);
            }
        } catch (SQLException e) {
            log.error("Error when getting all wallets", e);
        }

        return list;
    }

    @Override
    public void exchangeById(int idFirst, int idSecond, int sum) {
        log.info("Exchange money");
        PreparedStatement statement = null;
        String sqlFrom = "UPDATE wallets SET sum = sum - ? WHERE id = ?";
        String sqlTo = "UPDATE wallets SET sum = sum + ? WHERE id = ?";
        int result;

        try(Connection connection = daoFactory.getConnection()) {
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
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            log.error("Error when making exchange", e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                log.error("Error when closing resources", e);
            }
        }
    }

    @Override
    public void changeBalanceById(int id, int sum) {
        log.info("Change balance");
        String sql = "UPDATE wallets SET sum = sum + ? WHERE id = ?";
        int result;

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, sum);
            statement.setInt(2, id);
            result = statement.executeUpdate();

            if (result == 1) {
                log.info("The sum is update");
            }
        } catch (SQLException e) {
            log.error("Error when change balance", e);
        }
    }

    public Wallet readWalletById(int id) {
        log.info("Read wallet");
        String sql = "SELECT * FROM wallets WHERE id = ?";
        Wallet wallet = new Wallet();

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                wallet.setId(resultSet.getInt("id"));
                wallet.setUserId(resultSet.getInt("users_id"));
                wallet.setSystemId(resultSet.getInt("system_id"));
                wallet.setCurrencyId(resultSet.getInt("currency_id"));
                wallet.setSum(resultSet.getInt("sum"));
            }
        } catch (SQLException e) {
            log.error("Error when reading wallet's data by wallet's id", e);
        }

        return wallet;
    }

}
