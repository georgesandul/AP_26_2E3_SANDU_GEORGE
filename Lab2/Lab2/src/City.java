/** Un oras cu o populatie. */
public final class City extends Location {
    private int population;

    public City(int x, int y, String name, int population){
        super(x,y,name);
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "name=" + getName() +
                ", population=" + population +
                '}';
    }
}
