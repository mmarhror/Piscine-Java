
class Excalibur {

    String name;
    private static Excalibur INSTANCE;

    private Excalibur(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    private static Excalibur getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Excalibur("Sword");
        }

        return INSTANCE;
    }

}
