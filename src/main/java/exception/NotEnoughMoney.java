package exception;
/**
 * Created by SpiritMoo
 */
public class NotEnoughMoney extends RuntimeException {
    public NotEnoughMoney(String s) {
        super(s);
    }

    public NotEnoughMoney(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NotEnoughMoney(Throwable throwable) {
        super(throwable);
    }

    protected NotEnoughMoney(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
