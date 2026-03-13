import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private List<Profile> profiles = new ArrayList<>();

    public void addProfile(Profile p) {
        profiles.add(p);
    }

    public int getImportance(Profile target) {
        int importance = 0;

        if (target instanceof Person) {
            importance += ((Person) target).getRelationships().size();
        }

        for (Profile p : profiles) {
            if (p instanceof Person) {
                Person person = (Person) p;
                if (person != target && person.getRelationships().containsKey(target)) {
                    importance++;
                }
            }
        }
        return importance;
    }

    public void printNetwork() {
        profiles.sort((p1, p2) -> Integer.compare(getImportance(p2), getImportance(p1)));

        System.out.println("Social Network:");
        for (Profile p : profiles) {
            System.out.println(p.getName() + ", importance/nb of employees: " + getImportance(p));
        }
    }

    @Override
    public String toString() {
        return "SocialNetwork{" +
                "profiles=" + profiles +
                '}';
    }
}