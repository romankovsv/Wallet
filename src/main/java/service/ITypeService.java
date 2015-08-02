package service;

import database.type.Type;

import java.util.List;

public interface ITypeService {

    void create(Type type);

    Type read(int id);

    void update(int id, String name);

    void delete(int id);

    List<Type> getAll();
}
