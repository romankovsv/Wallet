package domain;

import java.sql.Date;
import java.sql.Time;

public class History {
    private int id;
    private int userIdFrom;
    private int userIdTo;
    private int walletIdFrom;
    private int walletIdTo;
    private Time time;
    private Date date;
    private int sum;

    public History() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserIdFrom() {
        return userIdFrom;
    }

    public void setUserIdFrom(int userIdFrom) {
        this.userIdFrom = userIdFrom;
    }

    public int getUserIdTo() {
        return userIdTo;
    }

    public void setUserIdTo(int userIdTo) {
        this.userIdTo = userIdTo;
    }

    public int getWalletIdFrom() {
        return walletIdFrom;
    }

    public void setWalletIdFrom(int walletIdFrom) {
        this.walletIdFrom = walletIdFrom;
    }

    public int getWalletIdTo() {
        return walletIdTo;
    }

    public void setWalletIdTo(int walletIdTo) {
        this.walletIdTo = walletIdTo;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
