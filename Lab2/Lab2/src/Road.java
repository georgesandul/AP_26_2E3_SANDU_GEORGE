public class Road {
    private String type;
    private int length, speedLimit;

    private Location location1;
    private Location location2;

    public Road(String type, int length, int speedLimit, Location location1, Location location2) {
        this.type = type;
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

    public String getType() {
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

    public void setType(String type) {
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
                "type='" + type + '\'' +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                ", location1=" + location1 +
                ", location2=" + location2 +
                '}';
    }
}
