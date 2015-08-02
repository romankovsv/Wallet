package service;

import database.history.History;

import java.util.List;

public interface IHistoryService {

    void create(History history);

    List<History> read(int id);

    void delete(int id);

    List<History> getAll();
}
