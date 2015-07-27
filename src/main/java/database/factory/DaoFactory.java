package database.factory;
/**
 * Created by SpiritMoon
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
/** Фабрика объектов для работы с базой данных */
public interface DaoFactory {
    /** Возвращает подключение к базе данных */
    Connection getConnection() throws SQLException, IOException;
}
