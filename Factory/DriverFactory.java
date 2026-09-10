
class DriverFactory {

    Driver getDriver(String type) {
        return switch (type) {
            case "CarDriver" ->
                new CarDriver();
            case "Plane" ->
                new PlaneDriver();
            default ->
                null;
        };
    }

}
