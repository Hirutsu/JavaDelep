import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MyApplicationFive {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int size = 1000000;
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++){
            list.add(random.nextInt(size));
        }

        Supplier<Stream> stream = () -> list.stream();

        System.out.println("Четные числа");
        List<Integer> evenNums = stream.get().filter(x-> Integer.parseInt(x.toString())%2 == 0).toList();
        System.out.println(evenNums.toString());

        System.out.println("Не четные числа");
        List<Integer> notEvenNums = stream.get().filter(x-> Integer.parseInt(x.toString())%2 != 0).toList();
        System.out.println(notEvenNums.toString());

        List<Integer> doubleList = stream.get().map(x-> Integer.parseInt(x.toString()) * 2).toList();
        System.out.println(doubleList);

        List<Integer> unList = stream.get().distinct().toList();
        System.out.println(unList.size());

        List<Integer> sortedList = stream.get().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sortedList);

        Optional<Integer> sentence = stream.get().reduce((x,y)-> Integer.parseInt(x.toString()) + Integer.parseInt(y.toString()));
        System.out.println(sentence.get());
    }
}

