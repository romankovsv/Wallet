package tables.wallets;

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
        String sql = "SELECT * FROM wallets WHERE users_id = " + id +"";

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
        String sql = "DELETE FROM wallets WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

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

    public MySqlWalletDao(Connection connection) { this.connection = connection; }
}
