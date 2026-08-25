
public class CelestialObject {

    public double x;
    public double y;
    public double z;
    public String name;

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
}
