package tables.system;
/**
 * Created by SpiritMoon
 */
public class SystemType {
    private int id;
    private String name;

    public SystemType() {}

    public SystemType(String name) {
        this.name = name;
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
}
