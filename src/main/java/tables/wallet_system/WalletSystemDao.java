package tables.wallet_system;

import tables.system.SystemType;
import tables.wallets.Wallet;

import java.util.List;

/**
 * Created by SpiritMoon
 */
public interface WalletSystemDao {
    /** Сохранить объект WalletSystem в базе данных */
    void create(Wallet wallet, SystemType systemType);
    /** Извлечь объек WalletSystem используя SystemType.id и Currency.id */
    WalletSystem read(int id);
    /** Внести изменения в WalletSystem используя SystemType.id и Currency.id */
    void update(int wallets_id, int system_id, int id);
    /** Удалить обхъект WalletSystem используя SystemType.id и Currency.id */
    void delete(int id);
    //** Вывести все записи WalletSystem */
    List<WalletSystem> getAll();
}
