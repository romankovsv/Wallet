package service.impl;

import database.type.Type;
import database.type.TypeDao;
import service.ISystemTypeService;

import java.util.List;

public class SystemTypeService implements ISystemTypeService {
    private TypeDao typeDao;

    @Override
    public void create(Type type) {
        typeDao.create(type);
    }

    @Override
    public Type read(int id) {
        return typeDao.read(id);
    }

    @Override
    public void update(int id, String name) {
        typeDao.update(id, name);
    }

    @Override
    public void delete(int id) {
        typeDao.delete(id);
    }

    @Override
    public List<Type> getAll() {
        return typeDao.getAll();
    }
}
