package database.system;

import java.util.List;

public interface SystemTypeDao {

    void create(SystemType systemType);

    SystemType read(int id);

    void update(int id, String name);

    void delete(int id);

    List<SystemType> getAll();
}
