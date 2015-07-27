package service.impl;

import database.system.SystemType;
import database.system.SystemTypeDao;
import service.ISystemTypeService;

import java.util.List;
/**
 * Created by SpiritMoon
 */
public class SystemTypeService implements ISystemTypeService {
    private SystemTypeDao systemTypeDao;

    @Override
    public void create(SystemType systemType) {
        systemTypeDao.create(systemType);
    }

    @Override
    public SystemType read(int id) {
        return systemTypeDao.read(id);
    }

    @Override
    public void update(int id, String name) {
        systemTypeDao.update(id, name);
    }

    @Override
    public void delete(int id) {
        systemTypeDao.delete(id);
    }

    @Override
    public List<SystemType> getAll() {
        return systemTypeDao.getAll();
    }
}
