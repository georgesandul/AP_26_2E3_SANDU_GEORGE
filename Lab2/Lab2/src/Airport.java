/** Un aeroport cu numarul de terminals. */
public final class Airport extends Location {
    private int nbTerminals;

    public Airport(int x, int y, String name, int nbTerminals){
        super(x,y,name);
        this.nbTerminals = nbTerminals;
    }

    public int getNbTerminals() {
        return nbTerminals;
    }

    public void setNbTerminals(int nbTerminals) {
        this.nbTerminals = nbTerminals;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name=" + getName() +
                ", nbTerminals=" + nbTerminals +
                '}';
    }
}
