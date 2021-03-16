package LinkedList;

public class SinglyLinkedList<T> implements LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public SinglyLinkedList(T[] vals) {
        this();
        for (T val : vals) {
            this.add(val);
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int idx) {
        if (idx >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> curr = this.head;
        for (int i = 0; i < idx; i++) {
            curr = curr.getNext();
        }
        return curr.getVal();
    }

    @Override
    public boolean find(T val) {
        Node<T> curr = this.head;
        while (curr != null) {
            if (curr.getVal().equals(val)) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    @Override
    public void add(T val) {
        Node<T> newNode = new Node<>(val);
        if (head == null) {
            this.head = newNode;
        } else {
            tail.setNext(newNode);
        }
        this.tail = newNode;
        this.size++;
    }

    @Override
    public void add(int idx, T val) {
        if (idx == 0) {
            // Add to beginning
            Node<T> newHead = new Node<>(val);
            newHead.setNext(this.head);
            this.head = newHead;
            this.size++;
        } else if (idx == this.size) {
            // Add to very end
            this.add(val); // Increases size internally
        } else if (idx > this.size || idx < 0) {
            // Out of bounds
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> prev = null;
            Node<T> curr = this.head;
            Node<T> newNode = new Node<>(val);
            for (int i = 0; i < idx; i++) {
                prev = curr;
                curr = curr.getNext();
            }
            prev.setNext(newNode);
            newNode.setNext(curr);
            this.size++;
        }
    }

    @Override
    public boolean remove(T val) {
        Node<T> prev = null;
        Node<T> curr = this.head;
        for (int i = 0; i < this.size; i++) {
            if (curr == null) return false;
            if (curr.getVal().equals(val)) {
                if (prev == null) {
                    this.head = curr.getNext();
                } else {
                    prev.setNext(curr.getNext());
                }
                if (curr == this.tail) {
                    this.tail = prev;
                }
                this.size--;
                return true;
            }
            prev = curr;
            curr = curr.getNext();
        }
        return false;
    }

    @Override
    public boolean removeAt(int idx) {
        if (idx == 0) {
            this.head = this.head.getNext();
        } else if (idx >= this.size || idx < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> prev = null;
            Node<T> curr = this.head;
            for (int i = 0; i < idx; i++) {
                prev = curr;
                curr = curr.getNext();
            }
            if (curr == this.tail) {
                this.tail = prev;
            }
            prev.setNext(curr.getNext());
        }
        this.size--;
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> curr = this.head;
        for (int i = 0; i < this.size; i++) {
            sb.append(curr.getVal().toString());
            if (i != this.size - 1) {
                sb.append(", ");
            }
            curr = curr.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
