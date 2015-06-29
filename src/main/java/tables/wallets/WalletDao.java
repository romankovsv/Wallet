package tables.wallets;

import java.util.List;
/**
 * Created by SpiritMoon
 */
public interface WalletDao {
    /** Сохранить объект Wallet в базе данных для указанного User.id */
    void create(int userId, int systemId, int currencyId);
    /** Извлечь все объекты Wallet для указанного User.id */
    List<Wallet> readByUserId(int id);
    /** Внести изменения в Wallet по Wallet.id */
    void update(int id, int sum);
    /** Удалить объект Wallet по Wallet.id */
    void delete(int id);
    /** Удалить объект все Wallet по User.id */
    void deleteUserWallets(int id);
    /** Вывод всех записей по Wallet */
    List<Wallet> getAll();
    /** Обмен между кошельками по Wallet.id */
    void exchange(int idFirst, int idSecond, int sum);
    /** Пополнение кошелька по Wallet.id */
    void changeBalance(int id, int sum);
    /** Извлечь все объекты Wallet для указанного Wallet.id */
    Wallet readByWalletId(int id);
}
