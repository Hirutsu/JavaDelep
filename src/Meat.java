public class Meat extends Product implements java.io.Serializable {
    public Meat(String name, int kal,int weight) throws KalException, WeightException {
        super(name,kal,weight);
    }
}
