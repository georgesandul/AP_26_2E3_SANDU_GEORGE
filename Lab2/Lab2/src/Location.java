import java.util.Objects;

/**
 * O locatie abstracta in problema.
 * Clasa sealed care lasa doar City Airport si GasStation sa mosteneasca.
 */

public abstract sealed class Location permits City, Airport, GasStation {
    private String name;
    private int x, y;

    public Location(int y, int x, String name) {
        this.y = y;
        this.x = x;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x && y == location.y && Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
