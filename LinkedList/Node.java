public class Node<T> {
    private T val;
    private Node<T> prev;
    private Node<T> next;

    /**
     * Constructor
     * @param val value of the node
     */
    public Node(T val) {
        this.val = val;
    }

    /**
     * Gets value
     * @return value of node
     */
    public T getVal() {
        return val;
    }

    /**
     * Sets value
     * @param val value to set
     */
    public void setVal(T val) {
        this.val = val;
    }

    /**
     * Gets previous node
     * @return previous node
     */
    public Node<T> getPrev() {
        return prev;
    }

    /**
     * Sets previous node
     * @param prev node to set as previous
     */
    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    /**
     * Gets next node
     * @return next node
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Sets next ndoe
     * @param next node to set as next
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
