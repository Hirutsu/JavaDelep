
import java.util.Random;

class MyApplicationOne {

    public final int N = 20;

    MyApplicationOne() {
    }

    public static void main(String[] args) {
        MyApplicationOne app = new MyApplicationOne();
        app.startApplication();
    }

    private void startApplication() {
        //взял 1 вариант
        int[] arr = new int[20];
        this.GenRanArr(arr);
        this.ShowArr(arr);
        int[] answerFirst = this.SwapMaxNegMinPos(arr);
        this.ShowArr(answerFirst);
        this.Calculate(5,10);
    }

    private  void Calculate(int first, int second){
        System.out.println(first + "+" + second + "=" + (first + second) );
        System.out.println(first + "-" + second + "=" + (first - second) );
        System.out.println(first + "/" + second + "="+ (first / second) );
        int proiz = first * second;
        System.out.println(first + "*" + second + "=" + proiz );
    }

    private void ShowArr(int[] array) {
        for(int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }

    private void GenRanArr(int[] array) {
        Random rnd = new Random();

        for(int i = 0; i < array.length; ++i) {
            array[i] = rnd.nextInt(0, 20) - 10;
        }

    }

    private int[] SwapMaxNegMinPos(int[] array) {
        int[] arr = (int[])array.clone();
        int max = -2147483648;
        int maxId = -1;
        int min = 2147483647;
        int minId = -1;

        for(int i = 0; i < arr.length; ++i) {
            if (arr[i] < 0 && Math.abs(arr[i]) > max) {
                max = Math.abs(arr[i]);
                maxId = i;
            }

            if (arr[i] > 0 && min > arr[i]) {
                min = arr[i];
                minId = i;
            }
        }

        arr[minId] = -max;
        arr[maxId] = min;
        return arr;
    }
}
