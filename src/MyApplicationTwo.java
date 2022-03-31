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
        Dish dish = new Dish();

        if(dish.products == null){
            System.out.println("Invalid product, please repeat");
            return;
        }
        else{
            for (int i = 0; i < dish.products.length; i++){
                System.out.println(dish.products[i].Display());
            }
            System.out.println("All kal in product: " + dish.CalculateKal());
        }

        Arrays.sort(dish.products);

        for (int i = 0; i < dish.products.length; i++){
            System.out.println(dish.products[i].Display());
        }

        dish.FindProductBW();
    }
}
