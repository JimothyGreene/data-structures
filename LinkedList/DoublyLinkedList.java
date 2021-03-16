package LinkedList;

public class DoublyLinkedList<T> implements LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DoublyLinkedList(T[] vals) {
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
        if (idx < this.size / 2) {
            // First half (start at head)
            Node<T> curr = this.head;
            for (int i = 0; i < idx; i++) {
                curr = curr.getNext();
            }
            return curr.getVal();
        } else if (idx < this.size) {
            // Second half (start at tail)
            Node<T> curr = this.tail;
            for (int i = this.size-1; i > idx; i--) {
                curr = curr.getPrev();
            }
            return curr.getVal();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean find(T val) {
        Node<T> curr = this.head;   // Arbitrarily start from head
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
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.setPrev(this.tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
    }

    @Override
    public void add(int idx, T val) {
        Node<T> newNode = new Node<>(val);
        if (idx == 0) {
            newNode.setNext(this.head);
            if (this.head != null) {
                this.head.setPrev(newNode);
            }
            if (this.tail == null) {
                this.tail = newNode;
            }
            this.head = newNode;
            this.size++;
        } else if (idx < 0 || idx > this.size) {
            throw new IndexOutOfBoundsException();
        } else if (idx == this.size) {
            this.add(val);
        } else {
            Node<T> curr = null;
            Node<T> prev = null;
            if (idx < this.size / 2) {
                // Start at head
                curr = this.head;
                for (int i = 0; i < idx; i++) {
                    curr = curr.getNext();
                }
            } else {
                // Start at tail
                curr = this.tail;
                for (int i = this.size-1; i > idx; i--) {
                    curr = curr.getPrev();
                }
            }
            prev = curr.getPrev();
            prev.setNext(newNode);
            newNode.setPrev(prev);
            newNode.setNext(curr);
            curr.setPrev(newNode);
            this.size++;
        }
    }

    @Override
    public boolean remove(T val) {
        Node<T> curr = this.head;   // Start from head arbitrarily
        while (curr != null) {
            if (curr.getVal().equals(val)) {
                Node<T> prev = curr.getPrev();
                Node<T> next = curr.getNext();
                if (curr == this.head) {
                    if (next == null) {
                        this.head = null;
                        this.tail = null;
                    } else {
                        this.head = next;
                        next.setPrev(null);
                    }
                } else if (curr == this.tail) {
                    if (prev == null) {
                        this.head = null;
                        this.tail = null;
                    } else {
                        this.tail = prev;
                        prev.setNext(null);
                    }
                } else {
                    prev.setNext(next);
                    next.setPrev(prev);
                }
                this.size--;
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    @Override
    public boolean removeAt(int idx) {
        if (idx > this.size) {
            throw new IndexOutOfBoundsException();
        } else if (idx == 0) {
            this.head = this.head.getNext();
            this.head.setPrev(null);
            this.size--;
            return true;
        } else if (idx == this.size - 1) {
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
            this.size--;
            return true;
        }
        Node<T> curr = null;
        if (idx < this.size / 2) {
            // First half (start at head)
            curr = this.head;
            for (int i = 0; i < idx; i++) {
                curr = curr.getNext();
            }
        } else if (idx < this.size) {
            // Second half (start at tail)
            curr = this.tail;
            for (int i = this.size-1; i > idx; i--) {
                curr = curr.getPrev();
            }
        } else {
            return false;
        }
        Node<T> prev = curr.getPrev();
        Node<T> next = curr.getNext();
        prev.setNext(next);
        next.setPrev(prev);

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
