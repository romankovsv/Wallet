package dao.impl;

import dao.factory.MySqlDaoFactory;
import dao.TypeCurrencyDao;
import domain.TypeCurrency;
import org.apache.log4j.Logger;
import domain.Currency;
import domain.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlTypeCurrencyDao implements TypeCurrencyDao {
    public static final Logger log = Logger.getLogger(MySqlTypeCurrencyDao.class);
    private MySqlDaoFactory daoFactory = new MySqlDaoFactory();

    @Override
    public void create(Type type, Currency currency) {
        log.info("Create type-currency dependency");
        String sql = "INSERT INTO type_currency (type_id, currency_id) VALUES (?, ?)";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, type.getId());
            statement.setInt(2, currency.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Error when creating new type-currency dependency", e);
        }
    }

    @Override
    public TypeCurrency read(int id) {
        log.info("Read type-currency dependency");
        TypeCurrency typeCurrency = new TypeCurrency();
        String sql = "SELECT * FROM type_currency WHERE id = ?";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            typeCurrency.setId(resultSet.getInt("id"));
            typeCurrency.setCurrencyId(resultSet.getInt("type_id"));
            typeCurrency.setCurrencyId(resultSet.getInt("currency_id"));
        } catch (SQLException e) {
            log.error("Error when reading type-currency dependency", e);
        }

        return typeCurrency;
    }

    @Override
    public void update(int system_id, int currency_id , int id) {
        log.info("Update type-currency dependency");
        String sql = "UPDATE type_currency SET type_id = ?, currency_id = ? WHERE id = ?";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, system_id);
            statement.setInt(2, currency_id);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Error when updating type-currency dependency", e);
        }
    }

    @Override
    public void delete(int id) {
        log.info("Delete type-currency dependency");
        String sql = "DELETE FROM type_currency WHERE id = ?";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            log.error("Error when deleting type-currency dependency", e);
        }
    }

    @Override
    public List<TypeCurrency> getAll() {
        log.info("Get all type-currency dependency");
        List<TypeCurrency> list = new ArrayList<>();
        String sql = "SELECT * FROM type_currency";

        try(Connection connection = daoFactory.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                TypeCurrency typeCurrency = new TypeCurrency();
                typeCurrency.setId(resultSet.getInt("id"));
                typeCurrency.setTypeId(resultSet.getInt("type_id"));
                typeCurrency.setCurrencyId(resultSet.getInt("currency_id"));
                list.add(typeCurrency);
            }
        } catch (SQLException e) {
            log.error("Error when getting all type-currency dependency", e);
        }

        return list;
    }

}
