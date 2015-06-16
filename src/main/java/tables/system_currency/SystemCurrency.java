package tables.system_currency;
/**
 * Created by SpiritMoon
 */
public class SystemCurrency {
    private int id;
    private int system_id;
    private int currency_id;

    SystemCurrency() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSystem_id() {
        return system_id;
    }

    public void setSystem_id(int system_id) {
        this.system_id = system_id;
    }

    public int getCurrency_id() {
        return currency_id;
    }

    public void setCurrency_id(int currency_id) {
        this.currency_id = currency_id;
    }
}
