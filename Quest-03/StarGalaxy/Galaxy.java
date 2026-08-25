
import java.util.ArrayList;
import java.util.List;

public class Galaxy extends CelestialObject {

    private List<CelestialObject> celestialObjects;

    public Galaxy() {
        super();
        celestialObjects = new ArrayList<>();
    }

    public List<CelestialObject> getCelestialObjects() {
        return celestialObjects;
    }

    public void setCelestialObjects(List<CelestialObject> l) {
        celestialObjects = l;
    }

    public void addCelestialObject(CelestialObject o) {
        celestialObjects.add(o);
    }

}
