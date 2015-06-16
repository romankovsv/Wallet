package tables.users;

import java.sql.Date;
/**
 * Created by SpiritMoon
 */
public class User {

    private int id;
    private String name;
    private String date_of_birth;
    private Date date_of_registration;
    private String sex;
    private String email;
    private String password;

    public User(){};

    public User(String name, String date_of_birth, String sex, String email, String password) {
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.sex = sex;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Date getDate_of_registration() {
        return date_of_registration;
    }

    public void setDate_of_registration(Date date_of_registration) {
        this.date_of_registration = date_of_registration;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
