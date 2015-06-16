package tables.wallet_system;
/**
 * Created by SpiritMoon
 */
public class WalletSystem {
    private int id;
    private int wallet_id;
    private int system_id;

    WalletSystem() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(int wallet_id) {
        this.wallet_id = wallet_id;
    }

    public int getSystem_id() {
        return system_id;
    }

    public void setSystem_id(int system_id) {
        this.system_id = system_id;
    }
}
