package service.history;

import domain.History;
import dao.history.HistoryDao;

import java.util.List;

public class HistoryServiceImp implements HistoryService {
    private HistoryDao historyDao;

    @Override
    public void create(History history) {
        historyDao.create(history);
    }

    @Override
    public List<History> read(int id) {
        return historyDao.readByUserId(id);
    }

    @Override
    public void delete(int id) {
        historyDao.deleteById(id);
    }

    @Override
    public List<History> getAll() {
        return historyDao.getAll();
    }
}
