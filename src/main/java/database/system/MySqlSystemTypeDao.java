package database.system;

import database.factory.MySqlDaoFactory;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlSystemTypeDao implements SystemTypeDao {
    private static final Logger log = Logger.getLogger(MySqlSystemTypeDao.class);
    private MySqlDaoFactory daoFactory = new MySqlDaoFactory();

    @Override
    public void create(SystemType systemType) {
        log.info("Create new system type");
        String sql = "INSERT INTO system (name) VALUES (?)";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, systemType.getName());

            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                log.info("A new system type was created successfully!");
            }
        } catch (SQLException e) {
            log.error("Error when creating new system type", e);
        }
    }

    @Override
    public SystemType read(int id) {
        log.info("Read system type");
        String sql = "SELECT * FROM system WHERE id = ?";
        SystemType systemType = new SystemType();

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            systemType.setId(resultSet.getInt("id"));
            systemType.setName(resultSet.getString("name"));
        } catch (SQLException e ) {
            log.error("Error when reading system type data", e);
        }

        return systemType;
    }

    @Override
    public void update(int id, String name) {
        log.info("Update system type");
        String sql = "UPDATE system SET name = ? WHERE id = ?";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                log.info("An existing system type was updated successfully!");
            }
        } catch (SQLException e) {
            log.error("Error when update system type", e);
        }
    }

    @Override
    public void delete(int id) {
        log.info("Delete system type");
        String sql = "DELETE FROM system WHERE id = ?;";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                log.info("A system type was deleted successfully!");
            }
        } catch (SQLException e) {
            log.error("Error when delete system type", e);
        }
    }

    @Override
    public List<SystemType> getAll() {
        log.info("Get all system type");
        List<SystemType> list = new ArrayList<>();
        String sql = "SELECT * FROM system;";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()) {
                SystemType systemType = new SystemType();
                systemType.setId(resultSet.getInt("id"));
                systemType.setName(resultSet.getString("name"));
                list.add(systemType);
            }
        } catch (SQLException e) {
            log.error("Error when getting all system type's", e);
        }

        return list;
    }

}
