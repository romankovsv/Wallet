package tables.wallets;

import tables.currency.Currency;
import tables.system.SystemType;
/**
 * Created by SpiritMoon
 */
public class Wallet {
    private int id;
    private int user_id;
    private int sum;
    private SystemType systemType;
    private Currency currency;

    public Wallet() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public SystemType getSystemType() {
        return systemType;
    }

    public void setSystemType(SystemType systemType) {
        this.systemType = systemType;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
