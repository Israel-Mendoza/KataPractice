package easy.secondminandmax;

import java.util.Comparator;
import java.util.stream.IntStream;

// The algorithm finds the second minimum and maximum element in an array.
public class SecondMinAndMax {

    public static int findSecondMin(int[] arr) {
        return IntStream.of(arr)
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .getAsInt();
    }

    public static int findSecondMax(int[] arr) {
        return IntStream.of(arr)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 5};
        System.out.println("Original Array" + IntStream.of(arr).boxed().toList());
        System.out.printf("Second minimum: %d\n", findSecondMin(arr));
        System.out.printf("Second maximum: %d", findSecondMax(arr));
    }
}
