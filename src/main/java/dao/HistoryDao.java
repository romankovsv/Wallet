package dao;

import domain.History;

import java.util.List;

public interface HistoryDao {

    void create(History history);

    List<History> readByUserId(int id);

    void deleteById(int id);

    List<History> getAll();
}
