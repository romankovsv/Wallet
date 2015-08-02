package service.history;

import domain.History;

import java.util.List;

public interface HistoryService {

    void create(History history);

    List<History> read(int id);

    void delete(int id);

    List<History> getAll();
}
