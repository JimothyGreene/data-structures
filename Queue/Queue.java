package Queue;

import LinkedList.LinkedList;
import LinkedList.SinglyLinkedList;

public class Queue<T> {
    private LinkedList<T> data;
    private int size;

    public Queue() {
        this.data = new SinglyLinkedList<T>();
        this.size = 0;
    }

    /**
     * Checks if queue is empty
     * @return true if queue is empty, false else
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Enqueues a value into the queue
     * @param val value to be enqueued
     */
    public void enqueue(T val) {
        this.data.add(val);
        this.size++;
    }

    /**
     * Dequeues a value from the queue
     * @return value that was dequeued
     */
    public T dequeue() {
        T val = this.data.get(0);
        this.data.removeAt(0);
        this.size--;
        return val;
    }
}
