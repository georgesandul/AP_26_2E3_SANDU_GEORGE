public class Main {
    public static void main(String[] args) {
        Problem problema1 = new Problem(10,10);

        City bucuresti = new City(0, 0, "bucuresti", 1000000);
        City iasi = new City(250,300,"iasi", 250000);
        City timisoara = new City(-200, 50, "timisoara", 180000);
        Airport otopeni = new Airport(10,15,"henri coanda airport", 4);
        GasStation petrom = new GasStation(15,15,"petrom otopeni",8.05);

        Road autostrada1 = new Road(RoadType.HIGHWAY,"A7", 350,130, bucuresti, iasi);
        Road express1 = new Road(RoadType.EXPRESS, "DN58", 250, 140, bucuresti, timisoara);

        System.out.println("going from " + iasi.getName() + " to " + bucuresti.getName() + " on " + autostrada1.getType());

        problema1.addLocation(iasi);
        problema1.addLocation(bucuresti);
        problema1.addLocation(otopeni);
        problema1.addRoad(autostrada1);
        problema1.addRoad(express1); //daca bagam drumul asta nu mai e valida problema pt ca conecteaza bucuresti de timisoara dar timisoara nu e in problema asta.
        System.out.println(problema1);
        if(problema1.isValid()){
            System.out.println("problema e valida");
        }
        else{
            System.out.println("problema nu e valida");
        }
        if(problema1.canReach(iasi, bucuresti)){
            System.out.println("putem ajunge de la iasi la bucuresti");
        }
        else{
            System.out.println("nu putem ajunge de la iasi la bucuresti");
        }
    }
}