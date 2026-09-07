
class PlaneDriver extends Driver {

    Transport createTransport() {
        return TransportFactory.getTransport("Plane");
    }
}
