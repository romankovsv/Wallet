package tables.system;

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
    private Connection connection;

    @Override
    public void create(SystemType systemType) {
        String sql = "INSERT INTO system (name) VALUES (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, systemType.getName());

            int rowsInsert = statement.executeUpdate();
            if (rowsInsert > 0) {
                System.out.println("A new SystemType was created successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SystemType read(int id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        SystemType systemType = new SystemType();

        try {
            String sql = "SELEC * FROM system WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            systemType.setId(resultSet.getInt("id"));
            systemType.setName(resultSet.getString("name"));
        } catch (SQLException e ) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
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
                System.out.println("An existing SystemType was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM system WHERE id = ?;";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A SystemType was deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SystemType> getAll() {
        List<SystemType> list = new ArrayList<SystemType>();
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
            e.printStackTrace();
        }

        return list;
    }

    public MySqlSystemTypeDao(Connection connection) {
        this.connection = connection;
    }
}
