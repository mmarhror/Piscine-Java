
public class Excalibur {

    String name;
    public static Excalibur INSTANCE;

    Excalibur(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public static Excalibur getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Excalibur("Sword");
        }

        return INSTANCE;
    }

}
