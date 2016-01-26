package dao;

import domain.Wallet;

import java.util.List;

public interface WalletDao {

    void createForUserById(int userId, int systemId, int currencyId);

    List<Wallet> readForUserById(int id);

    void deleteById(int id);

    void deleteUserWalletById(int id);

    List<Wallet> getAll();

    void exchangeById(int idFirst, int idSecond, int sum);

    void changeBalanceById(int id, int sum);

    Wallet readWalletById(int id);
}
