public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.startApplication(1000000);
    }

    private void startApplication(Integer length) {
        int[] array;
        array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int)(Math.random() * length));
        }
        int[] array1 = new int[length];
        System.arraycopy(array, 0, array1, 0,array.length - 1);

        long start1 = System.currentTimeMillis();
        quickSort(array,0, length - 1);
        long end1 = System.currentTimeMillis();
        long time1 = end1 - start1;

        System.out.println("Common quicksort: " + time1);

        long start2 = System.currentTimeMillis();
        ThreadQuickSort quick = new ThreadQuickSort(array1, 0, array.length - 1);
        quick.run();
        long end2 = System.currentTimeMillis();
        long time2 = end2 - start2;

        System.out.println("Thread quicksort: " + time2);
    }

    public static void quickSort(int[] arr, int begin, int end){
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    public static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;
        return i+1;
    }
}