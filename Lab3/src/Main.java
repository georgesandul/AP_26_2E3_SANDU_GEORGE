import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Profile> network = new ArrayList<>();

        Person george = new Person ("George", "01");
        Person marius = new Person ("Marius", "02");
        Person aurelian = new Person ("Aurelian", "003");
        Company bitdef = new Company("Bitdefender", "001");
        Company cogni = new Company("Cognizant", "002");

        network.add(george);
        network.add(marius);
        network.add(aurelian);
        network.add(bitdef);
        network.add(cogni);

        Collections.sort(network);

        for(Profile profiles : network){
            System.out.println(profiles);
        }
    }
}