public class Fruit extends Product implements java.io.Serializable {
    public Fruit(String name, int kal,int weight) throws KalException, WeightException {
        super(name,kal,weight);
    }
}
