
import java.util.Objects;

public class Star extends CelestialObject {

    private double magnitude;

    public Star() {
        super();
    }

    public Star(String name, double x, double y, double z, double magnitude, int mass) {
        super(name, x, y, z, mass);
        this.magnitude = magnitude;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double mag) {
        magnitude = mag;
    }

    @Override
    public String toString() {
        return String.format("%s shines at the %.3f magnitude", name, magnitude);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Star)) {
            return false;
        }

        Star o = (Star) obj;

        return super.equals(o) && magnitude == o.magnitude;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), magnitude);
    }

}
