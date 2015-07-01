package custom.exceptions;
/**
 * Created by SpiritMoo
 */
public class NotEnoughMoney extends RuntimeException {
    public NotEnoughMoney() {
        super("Not enough money!");
    }
}
