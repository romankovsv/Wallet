package database.type;

import database.factory.MySqlDaoFactory;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlTypeDao implements TypeDao {
    private static final Logger log = Logger.getLogger(MySqlTypeDao.class);
    private MySqlDaoFactory daoFactory = new MySqlDaoFactory();

    @Override
    public void create(Type type) {
        log.info("Create new type type");
        String sql = "INSERT INTO type (name) VALUES (?)";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, type.getName());

            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                log.info("A new type type was created successfully!");
            }
        } catch (SQLException e) {
            log.error("Error when creating new type type", e);
        }
    }

    @Override
    public Type read(int id) {
        log.info("Read type type");
        String sql = "SELECT * FROM type WHERE id = ?";
        Type type = new Type();

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            type.setId(resultSet.getInt("id"));
            type.setName(resultSet.getString("name"));
        } catch (SQLException e ) {
            log.error("Error when reading type type data", e);
        }

        return type;
    }

    @Override
    public void update(int id, String name) {
        log.info("Update type type");
        String sql = "UPDATE type SET name = ? WHERE id = ?";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setInt(2, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                log.info("An existing type type was updated successfully!");
            }
        } catch (SQLException e) {
            log.error("Error when update type type", e);
        }
    }

    @Override
    public void delete(int id) {
        log.info("Delete type type");
        String sql = "DELETE FROM type WHERE id = ?;";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                log.info("A type type was deleted successfully!");
            }
        } catch (SQLException e) {
            log.error("Error when delete type type", e);
        }
    }

    @Override
    public List<Type> getAll() {
        log.info("Get all type type");
        List<Type> list = new ArrayList<>();
        String sql = "SELECT * FROM type;";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()) {
                Type type = new Type();
                type.setId(resultSet.getInt("id"));
                type.setName(resultSet.getString("name"));
                list.add(type);
            }
        } catch (SQLException e) {
            log.error("Error when getting all type type's", e);
        }

        return list;
    }

}
