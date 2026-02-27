public class Main {
    public static void main(String[] args) {
        Location oras1 = new Location(0,0,"City","Iasi");
        Location oras2 = new Location(100,150,"City","Bucharest");
        Location stop1 = new Location(50, 100, "Benzinarie", "Petrom");

        Road autostradaA7 = new Road("highway", 300,130,oras1,oras2);

        System.out.println("Going from " + oras1.getName() + " to " + oras2.getName() + ". One stop at " + stop1.getName() + " on the " + autostradaA7.getType());
    }
}