package tables.wallets;

import tables.users.User;

import java.util.List;
/**
 * Created by SpiritMoon
 */
public interface WalletDao {
    /** Сохранить объект Wallet в базе данных для указанного User.id */
    void create(int id);
    /** Извлечь объек Wallet используя указанный User.id */
    Wallet read(int id);
    /** Внести изменения в Wallet по User.id */
    void update(int id, int sum);
    /** Удалить объект Wallet по User.id */
    void delete(int id);
    //** Вывод всех записей по Wallet по User.id */
    List<Wallet> getAll(int id);

}
