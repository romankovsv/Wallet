package service.wallets;

import domain.Wallet;

import java.util.List;

public interface WalletService {

    void create(int userId, int systemId, int currencyId);

    List<Wallet> readByUserId(int id);

    void delete(int id);

    void deleteUserWallets(int id);

    List<Wallet> getAll();

    void exchange(int idFirst, int idSecond, int sum);

    void changeBalance(int id, int sum);

    Wallet readByWalletId(int id);
}
