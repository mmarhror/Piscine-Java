
class TransportFactory {

    static Transport getTransport(String type) {
        return switch (type) {
            case "Car" ->
                new Car();
            case "Plane" ->
                new Plane();
            default ->
                null;
        };
    }
}
