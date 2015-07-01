package tables.system;

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
public class MySqlSystemTypeDao implements SystemTypeDao {
    private static final Logger log = Logger.getLogger(MySqlSystemTypeDao.class);
    private Connection connection;

    @Override
    public void create(SystemType systemType) {
        String sql = "INSERT INTO system (name) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, systemType.getName());

            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                log.info("A new SystemType was created successfully!");
            }
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public SystemType read(int id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        SystemType systemType = new SystemType();

        try {
            String sql = "SELECT * FROM system WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            systemType.setId(resultSet.getInt("id"));
            systemType.setName(resultSet.getString("name"));
        } catch (SQLException e ) {
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

        return systemType;
    }

    @Override
    public void update(int id, String name) {
        String sql = "UPDATE system SET name = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                log.info("An existing SystemType was updated successfully!");
            }
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM system WHERE id = ?;";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                log.info("A SystemType was deleted successfully!");
            }
        } catch (SQLException e) {
            log.error(e);
        }
    }

    @Override
    public List<SystemType> getAll() {
        List<SystemType> list = new ArrayList<>();
        String sql = "SELECT * FROM system;";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()) {
                SystemType systemType = new SystemType();
                systemType.setId(resultSet.getInt("id"));
                systemType.setName(resultSet.getString("name"));
                list.add(systemType);
            }
        } catch (SQLException e) {
            log.error(e);
        }

        return list;
    }

    public MySqlSystemTypeDao(Connection connection) {
        this.connection = connection;
    }
}
