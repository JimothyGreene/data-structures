package Stack;

import LinkedList.LinkedList;
import LinkedList.SinglyLinkedList;

public class Stack<T> {
    private LinkedList<T> data;
    private int size;

    public Stack() {
        this.data = new SinglyLinkedList<T>();
        this.size = 0;
    }

    /**
     * Checks if the stack is empty
     * @return true if stack is empty, false else
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Looks at the top of the stack without popping
     * @return data at the top of the stack
     */
    public T peek() {
        return this.data.get(this.size - 1);
    }

    /**
     * Pushes a value onto the stack
     * @param val value to be pushed
     */
    public void push(T val) {
        this.data.add(val);
        this.size++;
    }

    /**
     * Pops a value off the stack
     * @return value popped off
     */
    public T pop() {
        T val = this.data.get(this.size - 1);
        this.data.removeAt(this.size - 1);
        this.size--;
        return val;
    }
}
