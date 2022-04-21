import java.io.*;
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
        writeObject(dish);
        readObject();
    }

    public void writeObject(Dish dish){
        try {
            FileOutputStream fos = new FileOutputStream("dish.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dish);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readObject(){
        try {
            FileInputStream fis = new FileInputStream("dish.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Dish dish = (Dish) ois.readObject();
            for (int i = 0; i < dish.products.length; i++){
                System.out.println(dish.products[i].Display());
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
