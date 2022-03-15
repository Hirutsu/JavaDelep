import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.*;

public class MyApplicationTwo {

    public static void main(String[] args) {
        MyApplicationTwo app = new MyApplicationTwo();
        app.startApplication();
    }

    private void startApplication() {
        int n = 3;
        Product[] first = CreateDish();

        if(first == null){
            System.out.println("Invalid product");
        }
        else{
            for (int i = 0; i < first.length; i++){
                System.out.println(first[i].Display());
            }
            System.out.println("All kal in product: " + CalculateKal(first));
        }

        Arrays.sort(first);

        for (int i = 0; i < first.length; i++){
            System.out.println(first[i].Display());
        }

    }

    private Product[] CreateDish(){
        Scanner in = new Scanner(System.in);

        int n = 3;
        Product[] dish = new Product[n];

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
        return dish;
    }

    private int CalculateKal(Product[] product){
        int sum = 0;
        for (int i = 0; i < product.length; i++){
            sum += product[i].GetKal();
        }
        return sum;
    }
}
