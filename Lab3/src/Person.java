import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Person implements Profile, Comparable<Profile> {
    private Map<Profile, String> relationships = new HashMap<>();

    private String id;
    private String name;
    private LocalDate dob;
    private String hobby;

    public Person(String hobby, LocalDate dob, String name, String id) {
        this.hobby = hobby;
        this.dob = dob;
        this.name = name;
        this.id = id;
    }

    public void addRel(Profile profile, String relType){
        relationships.put(profile, relType);
    }

    public Map<Profile, String> getRelationships(){
        return relationships;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Profile other) {
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
