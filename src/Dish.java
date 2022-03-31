import java.util.Arrays;
import java.util.Scanner;

public class Dish {
    public Product[] products;

    public  Dish(){
        this.products = CreateDish();
    }

    public void FindProductBW(){
        Scanner in = new Scanner(System.in);
        int kalS, kalE, weightS, weightE;
        try {
            boolean flag = false;
            System.out.print("Input kalS: ");
            kalS = in.nextInt();
            System.out.print("Input kalE: ");
            kalE = in.nextInt();
            System.out.print("Input weightS: ");
            weightS = in.nextInt();
            System.out.print("Input weightE: ");
            weightE = in.nextInt();
            for (int i = 0; i < this.products.length; i++){
                if(kalS < this.products[i].GetKal() && this.products[i].GetKal() < kalE){
                    if(weightS < this.products[i].GetWeight() && this.products[i].GetWeight() < weightE){
                        System.out.println(this.products[i].Display());
                        flag = true;
                    }
                }
            }
            if(flag == false){
                System.out.println("Nothing with parameters");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Please, input correct values");
        }
    }

    public int CalculateKal(){
        int sum = 0;
        try{
            for (int i = 0; i < this.products.length; i++){
                sum += this.products[i].GetKal();
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return sum;
        }
        return sum;
    }

    private Product[] CreateDish(){
        Scanner in = new Scanner(System.in);

        int n = 1;
        Product[] dish = new Product[n];
        try{
            for (int i = 0; i < dish.length; i++){
                String name;
                int kal;
                int weight;

                System.out.print("Input type product (Vegetable,Meat,Fruit,Fish):");
                String type = in.next();

                System.out.print("Input name product :");
                name = in.next();
                System.out.print("Input kal in product :");
                kal = in.nextInt();
                System.out.print("Input weight in product :");
                weight = in.nextInt();

                switch (type){
                    case "Vegetable":
                        dish[i] = new Vegetable(name,kal,weight);
                        break;
                    case "Meat":
                        dish[i] = new Meat(name,kal,weight);
                        break;
                    case "Fruit":
                        dish[i] = new Fruit(name,kal,weight);
                        break;
                    case "Fish":
                        dish[i] = new FIsh(name,kal,weight);
                        break;
                    default:
                        System.out.println("A u stupid? WrongData");
                        return null;
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return dish;
    }
}
