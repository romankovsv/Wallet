package tables.wallet_system;

import tables.system.SystemType;
import tables.wallets.Wallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SpiritMoon
 */
public class MySqlWalletSystemDao implements WalletSystemDao {
    private Connection connection;

    @Override
    public void create(Wallet wallet, SystemType systemType) {
        String sql = "INSERT INTO wallet_system (wallets_id, system_id)  VALUES (?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, wallet.getId());
            statement.setInt(2, systemType.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public WalletSystem read(int id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        WalletSystem walletSystem = new WalletSystem();

        try {
            String sql = "SELEC * FROM wallet_system WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            walletSystem.setId(resultSet.getInt("id"));
            walletSystem.setWallet_id(resultSet.getInt("wallets_id"));
            walletSystem.setSystem_id(resultSet.getInt("system_id"));
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

        return walletSystem;
    }

    @Override
    public void update(int wallets_id, int system_id, int id) {
        String sql = "UPDATE wallet_system SET wallets_id = ?, system_id = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setInt(2, id);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM wallet_system WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<WalletSystem> getAll() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<WalletSystem> list = new ArrayList<WalletSystem>();
        String sql = "SELECT * FROM system_currency";

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                WalletSystem walletSystem = new WalletSystem();
                walletSystem.setId(resultSet.getInt("id"));
                walletSystem.setWallet_id(resultSet.getInt("wallets_id"));
                walletSystem.setSystem_id(resultSet.getInt("system_id"));
                list.add(walletSystem);
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

    public MySqlWalletSystemDao(Connection connection) {
        this.connection = connection;
    }
}
