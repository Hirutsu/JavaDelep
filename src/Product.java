public class Product implements Comparable<Product> {
    private String name;
    private int kal;
    private int weight;

    public Product(String name, int kal,int weight){
        this.name = name;
        this.kal = kal;
        this.weight = weight;
    }

    public String Display(){
       return (this.name + " " + this.kal + " " + this.weight);
    }

    public int GetKal(){
        return this.kal;
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
