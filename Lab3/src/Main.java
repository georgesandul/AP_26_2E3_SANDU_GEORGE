import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args){

        SocialNetwork network = new SocialNetwork();

        Programmer george = new Programmer("Sports", LocalDate.of(2004,4,23), "George", "P01", "Java");
        Designer julia = new Designer("Travel", LocalDate.of(2006,07,17), "Julia", "P02", "Photoshop");
        Company bitdef = new Company("Bitdefender", "C01", 450.0);
        Company cogni = new Company("Cognizant", "C02", 560.0);

        network.addProfile(george);
        network.addProfile(julia);
        network.addProfile(bitdef);
        network.addProfile(cogni);

        george.addRel(bitdef,"Dev");
        george.addRel(julia, "friend");

        julia.addRel(cogni,"Lead Designer");
        julia.addRel(bitdef,"part-time designer");

        network.printNetwork();

        //System.out.println();

        //System.out.println(network);
    }
}