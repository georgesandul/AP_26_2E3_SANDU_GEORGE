import java.util.Objects;

/**
 * Drumuri care conecteaza 2 locatii.
 * Lungimea nu poate fi mai mica decat distanta Euclideana.
 */

public class Road {
    private RoadType type;
    private String name;
    private int length, speedLimit;

    private Location location1;
    private Location location2;

    public Road(RoadType type, String name, int length, int speedLimit, Location location1, Location location2) {
        this.type = type;
        this.name = name;
        this.length = length;
        this.speedLimit = speedLimit;
        this.location1 = location1;
        this.location2 = location2;

        int x1 = location1.getX();
        int y1 = location1.getY();
        int x2 = location2.getX();
        int y2 = location2.getY();

        double euclideanDist = Math.sqrt(Math.pow(x2 - x1, 2)+ Math.pow(y2 - y1, 2));
        if(length < euclideanDist){
            this.length = (int) euclideanDist;
        }else{
            this.length = length;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return length == road.length && speedLimit == road.speedLimit && type == road.type && Objects.equals(name, road.name) && Objects.equals(location1, road.location1) && Objects.equals(location2, road.location2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name, length, speedLimit, location1, location2);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoadType getType() {
        return type;
    }

    public int getLength() {
        return length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public Location getLocation1() {
        return location1;
    }

    public Location getLocation2() {
        return location2;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public void setLocation1(Location location1) {
        this.location1 = location1;
    }

    public void setLocation2(Location location2) {
        this.location2 = location2;
    }

    @Override
    public String toString() {
        return "Road{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                ", location1=" + location1 +
                ", location2=" + location2 +
                '}';
    }
}
