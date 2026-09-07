
class Excalibur {

    String name;
    Excalibur INSTANCE;

    Excalibur(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    Excalibur getInstance() {
        return new Excalibur("Sword");
    }

}
