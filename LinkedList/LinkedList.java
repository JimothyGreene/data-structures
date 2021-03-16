/**
 * LinkedList
 */
public interface LinkedList<T> {
    /**
     * Gets size of list
     * @return size of list
     */
    public int size();

    /**
     * Gets value by index
     * @param idx of value to get
     * @return value at given index
     */
    public T get(int idx);
    
    /**
     * Finds a given value
     * @param val value to find
     * @return true if found, false else
     */
    public boolean find(T val);

    /**
     * Adds element to end of list
     * @param val value to add 
     */
    public void add(T val);

    /**
     * Adds element to list at given index
     * @param idx index to add element
     * @param val value to add
     */
    public void add(int idx, T val);

    /**
     * Removes value
     * @param val value to remove
     * @return true if removed, false else
     */
    public boolean remove(T val);

    /**
     * Removes value at index
     * @param idx to remove value
     * @return true if remvoed, false else
     */
    public boolean removeAt(int idx);
}
