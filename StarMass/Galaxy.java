
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Integer> computeMassRepartition() {
        Map<String, Integer> map = new HashMap<>();

        map.put("Star", 0);
        map.put("Planet", 0);
        map.put("Other", 0);

        for (CelestialObject obj : celestialObjects) {
            if (obj instanceof Star) {
                map.put("Star", map.get("Star") + obj.getMass());
            } else if (obj instanceof Planet) {
                map.put("Planet", map.get("Planet") + obj.getMass());
            } else {
                map.put("Other", map.get("Other") + obj.getMass ());
            }
        }

        return map;
    }
}
