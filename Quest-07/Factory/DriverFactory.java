
class DriverFactory {

    static Driver getDriver(String type) {
        return switch (type) {
            case "Car" ->
                new CarDriver();
            case "Plane" ->
                new PlaneDriver();
            default ->
                null;
        };
    }

}
