/** O benzinarie cu preturile la combustibil. */
public final class GasStation extends Location{
    private double gasPrice;

    public GasStation(int x, int y, String name, double gasPrice){
        super(x,y,name);
        this.gasPrice = gasPrice;
    }

    public double getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }

    @Override
    public String toString() {
        return "GasStation{" +
                "name=" + getName() +
                ", gasPrice=" + gasPrice +
                '}';
    }
}
