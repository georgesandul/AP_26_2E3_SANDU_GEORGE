import java.util.Arrays;

/**
 * Reprezinta o instanta a problemei.
 * Stocheaza locatiile si drumurile valide si are logica DFS.
 */

public class Problem {
    private Location[] locations;
    private Road[] roads;

    private int locationCount;
    private int roadCount;

    public Problem(int maxLocations, int maxRoads){
        this.locations = new Location[maxLocations];
        this.roads = new Road[maxRoads];
        this.locationCount = 0;
        this.roadCount = 0;
    }

    /** adauga locatie la problema. */

    public void addLocation(Location newLocation){
        if(locationCount >= locations.length){
            System.out.println("full map");
            return;
        }

        for(int i = 0; i < locationCount; i++){
            if(locations[i].equals(newLocation)){
                System.out.println("already exists :P");
                return;
            }
        }

        locations[locationCount] = newLocation;
        locationCount++;
    }

    /** adauga drum la problema.  */

    public void addRoad(Road newRoad){
        if(roadCount >= roads.length){
            System.out.println("no more concrete to build roads");
            return;
        }

        for(int i = 0; i < roadCount; i++){
            if(roads[i].equals(newRoad)){
                System.out.println("already exists");
                return;
            }
        }

        roads[roadCount] = newRoad;
        roadCount++;
    }

    /** verifica daca drumurile conecteaza locatii care se afla in problema. */
    public boolean isValid(){
        for(int i = 0; i < roadCount; i++){
            Road currentRoad = roads[i];

            Location start = currentRoad.getLocation1();
            Location end = currentRoad.getLocation2();

            boolean eStart = false;
            boolean eEnd = false;

            for(int j = 0; j < locationCount; j++){
                if(locations[j].equals(start)){
                    eStart = true;
                }
                if(locations[j].equals(end)){
                    eEnd = true;
                }
            }
            if(!eStart || !eEnd){
                return false;
            }
        }
        return true;
    }

    /** foloseste DFS ca sa verifice conectivitatea dintre locatii. */
    public boolean canReach(Location start, Location reach) {
        if (!isValid()) {
            System.out.println("problema invalida");
            return false;
        }

        boolean[] visited = new boolean[locationCount];

        return dfsHelper(start, reach, visited);
    }

    private boolean dfsHelper(Location current, Location reach, boolean[] visited) {
        if (current.equals(reach)) {
            return true;
        }

        // cautam unde ne aflam
        int currentIndex = -1;
        for (int i = 0; i < locationCount; i++) {
            if (locations[i].equals(current)) {
                currentIndex = i;
                break;
            }
        }

        if (visited[currentIndex]) {
            return false;
        }

        visited[currentIndex] = true;

        for (int i = 0; i < roadCount; i++) {
            Road road = roads[i];
            if (road.getLocation1().equals(current)) {
                if (dfsHelper(road.getLocation2(), reach, visited)) return true;
            } else if (road.getLocation2().equals(current)) {
                if (dfsHelper(road.getLocation1(), reach, visited)) return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "locations=" + Arrays.toString(locations) +
                ", roads=" + Arrays.toString(roads) +
                ", locationCount=" + locationCount +
                ", roadCount=" + roadCount +
                '}';
    }
}
