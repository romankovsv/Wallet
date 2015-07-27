package service.impl;

import database.wallets.Wallet;
import database.wallets.WalletDao;
import service.IWalletService;

import java.util.List;
/**
 * Created by SpiritMoon
 */
public class WalletService implements IWalletService {
    private WalletDao walletDao;

    @Override
    public void create(int userId, int systemId, int currencyId) {
        walletDao.createForUserById(userId, systemId, currencyId);
    }

    @Override
    public List<Wallet> readByUserId(int id) {
        return walletDao.readForUserById(id);
    }

    @Override
    public void delete(int id) {
        walletDao.deleteById(id);
    }

    @Override
    public void deleteUserWallets(int id) {
        walletDao.deleteUserWalletById(id);
    }

    @Override
    public List<Wallet> getAll() {
        return walletDao.getAll();
    }

    @Override
    public void exchange(int idFirst, int idSecond, int sum) {
        walletDao.exchangeById(idFirst, idSecond, sum);
    }

    @Override
    public void changeBalance(int id, int sum) {
        walletDao.changeBalanceById(id, sum);
    }

    @Override
    public Wallet readByWalletId(int id) {
        return walletDao.readWalletById(id);
    }
}
