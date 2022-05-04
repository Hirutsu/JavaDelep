import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MyApplicationSeven {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int size = 50;
        int[] list = new int[size];
        for (int i = 0; i < size-1; i++){
            list[i] = (random.nextInt(size));
        }
        int[] copyList = new int[size];
        System.arraycopy(list,0,list,0,list.length-1);

        long startTime = System.currentTimeMillis();
        quickSort(list,0,list.length-1);
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");

        ThreadedQuick th = new ThreadedQuick(copyList,0,copyList.length-1);
        startTime = System.currentTimeMillis();
        th.run();
        endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
}

