
import java.util.Objects;

public class CelestialObject {

    public double x;
    public double y;
    public double z;
    public String name;

    public int mass;

    public static final double KM_IN_ONE_AU = 150000000;

    public CelestialObject() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.name = "Soleil";
        this.mass = 0;

    }

    public CelestialObject(String name, double x, double y, double z, int mass) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
        this.mass = mass;
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

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
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

        return name.equals(o.name) && x == o.x && y == o.y && z == o.z && mass == o.mass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, name, mass);
    }
}
