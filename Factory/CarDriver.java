
class CarDriver extends Driver {

    Transport createTransport() {
        return TransportFactory.getTransport("Car");
    }
}
