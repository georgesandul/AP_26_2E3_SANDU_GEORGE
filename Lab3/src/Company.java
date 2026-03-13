public class Company implements Profile, Comparable<Profile> {
    private String id;
    private String name;
    private double budget;

    public Company(String name, String id, double budget) {
        this.name = name;
        this.id = id;
        this.budget = budget;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public int compareTo(Profile other) {
        return this.name.compareTo(other.getName());
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                '}';
    }
}
