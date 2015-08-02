package service;

import database.system.SystemType;

import java.util.List;

public interface ISystemTypeService {

    void create(SystemType systemType);

    SystemType read(int id);

    void update(int id, String name);

    void delete(int id);

    List<SystemType> getAll();
}
