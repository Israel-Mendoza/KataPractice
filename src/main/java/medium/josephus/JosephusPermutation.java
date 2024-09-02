package medium.josephus;

import java.util.ArrayList;
import java.util.List;

// This class uses the Josephus Node to create a circular linked list that can be used to solve the Josephus permutation
public class JosephusPermutation {

    public static void main(String[] args) {
        // Create a circular linked list
        JosephusNode<Integer> circularList = createCircularLinkedList(new Integer[] { 1, 2, 3, 4, 5, 6, 7});
        // Get the permutation
        List<Integer> permutation = josephusPermutation(circularList, 2);
        System.out.println(permutation);

        JosephusNode<String> circularList2 = createCircularLinkedList(new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i" });
        List<String> permutation2 = josephusPermutation(circularList2, 2);
        System.out.println(permutation2);
    }

    public static <T> List<T> josephusPermutation(JosephusNode<T> circularList, int jump) {
        List<T> result = new ArrayList<>();

        int counter = 0;
        JosephusNode<T> current = circularList;
        JosephusNode<T> temporal = circularList;
        while (current.getNext() != current) {
            counter++;
            if (counter == jump) {
                result.add(current.getData());
                temporal.setNext(current.getNext());
                current = current.getNext();
                counter = 0;
            } else {
                temporal = current;
                current = current.getNext();
            }
        }
        result.add(current.getData());
        return result;
    }

    // A method that creates a circular list of nodes based on an array
    public static <T> JosephusNode<T> createCircularLinkedList(T[] arrayOfItems) {
        // If the array is empty
        if (arrayOfItems == null || arrayOfItems.length == 0) {
            return null;
        }
        JosephusNode<T> head = new JosephusNode<>(arrayOfItems[0]);
        JosephusNode<T> current = head;
        for (int i = 1; i < arrayOfItems.length; i++) {
            current.setNext(new JosephusNode<>(arrayOfItems[i]));
            current = current.getNext();
        }
        current.setNext(head);
        return head;
    }

}
