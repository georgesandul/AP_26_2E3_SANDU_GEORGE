public class Location {
    private String name;
    private LocationType type;
    private int x, y;

    public Location(int y, int x, LocationType type, String name) {
        this.y = y;
        this.x = x;
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LocationType getType() {
        return type;
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

    public void setType(LocationType type) {
        this.type = type;
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
                ", type='" + type + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
