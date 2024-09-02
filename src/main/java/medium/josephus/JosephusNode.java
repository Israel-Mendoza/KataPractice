package medium.josephus;

// A simple node class for the Josephus problem
public class JosephusNode<T> {
    // The node is capable of storing any data type (Integer, String, Double, etc...)
    private T data;
    private JosephusNode<T> next;

    public JosephusNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public JosephusNode<T> getNext() {
        return next;
    }

    public void setNext(JosephusNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "JosephusNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
