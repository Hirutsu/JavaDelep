class MyApplicationFourth {
    public static void main(String[] args) throws Exception {
        // creating integer array
        final int capacity = 2;
        DynamicArray<Integer>array = new DynamicArray(capacity);
        array.set(1);
        array.set(2);
        array.set(3);
        array.set(4);
        array.set(5);
        array.set(6);
        array.set(7);
        array.set(5);
        System.out.println(array.toString());
        array.set(5,10);
        System.out.println(array.toString());
        array.removeElementAt(5);
        System.out.println(array.toString());
        System.out.println(array.get(5));

        for (int itVar : array)
        {
            System.out.print(itVar + " ");
        }
    }
}
