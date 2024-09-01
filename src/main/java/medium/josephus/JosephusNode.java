package medium.josephus;

// A simple node class for the Josephus problem
public class JosephusNode {
    // The node is capable of storing any data type (Integer, String, Double, etc...)
    private Object data;
    private JosephusNode next;

    public JosephusNode(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JosephusNode getNext() {
        return next;
    }

    public void setNext(JosephusNode next) {
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
