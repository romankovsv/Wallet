package tables.transaction;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by SpiritMoon
 */
public class MySqlHistoryDao implements HistoryDao {
    private static final Logger log = Logger.getLogger(MySqlHistoryDao.class);
    private Connection connection;

    @Override
    public void create(History history) {
        String sql =
                "INSERT INTO history (user_id_from, user_id_to, wallet_id_from, wallet_id_to, time, date, sum) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, history.getUserIdFrom());
            statement.setInt(2, history.getUserIdTo());
            statement.setInt(3, history.getWalletIdFrom());
            statement.setInt(4, history.getWalletIdTo());
            statement.setTime(5, new Time(new Date(System.currentTimeMillis()).getTime()));
            statement.setDate(6, new Date(System.currentTimeMillis()));
            statement.setInt(7, history.getSum());

            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                log.info("A new history was created successfully!");
            }
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public List<History> read(int id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM history WHERE user_id_from = ? OR user_id_to = ?";
        List<History> list = new ArrayList<>();

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setInt(2, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                History history = new History();
                history.setId(resultSet.getInt("id"));
                history.setUserIdFrom(resultSet.getInt("user_id_from"));
                history.setUserIdTo(resultSet.getInt("user_id_to"));
                history.setWalletIdFrom(resultSet.getInt("wallet_id_from"));
                history.setWalletIdTo(resultSet.getInt("wallet_id_to"));
                history.setTime(resultSet.getTime("time"));
                history.setDate(resultSet.getDate("date"));
                history.setSum(resultSet.getInt("sum"));
                list.add(history);
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
    public void update(int id) {

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM history WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                log.info("A history was deleted successfully!");
            }
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public List<History> getAll() {
        List<History> list = new ArrayList<>();
        String sql = "SELECT * FROM history";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()) {
                History history = new History();
                history.setId(resultSet.getInt("id"));
                history.setUserIdFrom(resultSet.getInt("user_id_from"));
                history.setUserIdTo(resultSet.getInt("user_id_to"));
                history.setWalletIdFrom(resultSet.getInt("wallet_id_from"));
                history.setWalletIdTo(resultSet.getInt("wallet_id_to"));
                history.setDate(resultSet.getDate("date"));
                history.setSum(resultSet.getInt("sum"));
                list.add(history);
            }
        } catch (SQLException e) {
            log.error(e);
        }

        return list;
    }



    public MySqlHistoryDao(Connection connection) {
        this.connection = connection;
    }
}
