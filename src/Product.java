public class Product implements Comparable<Product>,java.io.Serializable {
    private String name;
    private int kal;
    private int weight;

    public Product(String name, int kal,int weight) throws KalException, WeightException {
        this.name = name;
        if (kal < 0){
            throw new KalException("calories cannot be lower than 0");
        }
        this.kal = kal;
        if (weight < 0){
            throw new WeightException("weight cannot be lower than 0");
        }
        this.weight = weight;
    }
    public String Display(){
       return (this.name + " " + this.kal + " " + this.weight);
    }

    public int GetKal(){
        return this.kal;
    }

    public int GetWeight(){
        return this.weight;
    }

    @Override
    public int compareTo(Product product) {
        if (this.kal < product.kal){
            return  -1;
        }
        else if (this.kal > product.kal){
            return 1;
        }
        else {
            return 0;
        }
    }
}
