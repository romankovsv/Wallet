package dao;

import domain.Type;

import java.util.List;

public interface TypeDao {

    void create(Type type);

    Type read(int id);

    void update(int id, String name);

    void delete(int id);

    List<Type> getAll();
}
