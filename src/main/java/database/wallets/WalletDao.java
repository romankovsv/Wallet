package database.wallets;

import java.util.List;
/**
 * Created by SpiritMoon
 */
public interface WalletDao {
    /** Сохранить объект Wallet в базе данных для указанного User.id */
    void createForUserById(int userId, int systemId, int currencyId);
    /** Извлечь все объекты Wallet для указанного User.id */
    List<Wallet> readForUserById(int id);
    /** Удалить объект Wallet по Wallet.id */
    void deleteById(int id);
    /** Удалить объект все Wallet по User.id */
    void deleteUserWalletById(int id);
    /** Вывод всех записей по Wallet */
    List<Wallet> getAll();
    /** Обмен между кошельками по Wallet.id */
    void exchangeById(int idFirst, int idSecond, int sum);
    /** Пополнение кошелька по Wallet.id */
    void changeBalanceById(int id, int sum);
    /** Извлечь все объекты Wallet для указанного Wallet.id */
    Wallet readWalletById(int id);
}
