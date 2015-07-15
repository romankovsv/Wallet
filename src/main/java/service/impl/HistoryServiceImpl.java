package service.impl;

import database.history.History;
import database.history.HistoryDao;
import service.HistoryService;

import java.util.List;
/**
 * Created by SpiritMoon
 */
public class HistoryServiceImpl implements HistoryService {
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
    public void update(int id) {
        historyDao.updateById(id);
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
