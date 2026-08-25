
import java.util.Objects;

public class CelestialObject {

    public double x;
    public double y;
    public double z;
    public String name;

    public static final double KM_IN_ONE_AU = 150000000;

    public CelestialObject() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.name = "Soleil";
    }

    public CelestialObject(String name, double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double nx) {
        this.x = nx;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double ny) {
        this.y = ny;
    }

    public double getZ() {
        return this.z;
    }

    public void setZ(double nz) {
        this.z = nz;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String nname) {
        this.name = nname;
    }

    public static double getDistanceBetween(CelestialObject o1, CelestialObject o2) {
        double sum = Math.pow(o2.x - o1.x, 2) + Math.pow(o2.y - o1.y, 2) + Math.pow(o2.z - o1.z, 2);

        return Math.sqrt(sum);
    }

    public static double getDistanceBetweenInKm(CelestialObject a, CelestialObject b) {
        return getDistanceBetween(a, b) * KM_IN_ONE_AU;
    }

    @Override
    public String toString() {
        return String.format("%s is positioned at (%.3f, %.3f, %.3f)", name, x, y, z);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CelestialObject)) {
            return false;
        }

        CelestialObject o = (CelestialObject) obj;

        return name.equals(o.name) && x == o.x && y == o.y && z == o.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, name);
    }
}
