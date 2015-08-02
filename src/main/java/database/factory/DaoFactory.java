package database.factory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public interface DaoFactory {

    Connection getConnection() throws SQLException, IOException;
}
