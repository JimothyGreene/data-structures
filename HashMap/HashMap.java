package HashMap;

import java.util.*;

public class HashMap<K, V> {
    private final static int INITIAL_CAPACITY = 100;
    private int capacity;
    private ArrayList<LinkedList<HashNode<K, V>>> data;
    private Set<K> keySet;

    public HashMap() {
        this.capacity = INITIAL_CAPACITY;
        this.keySet = new HashSet<K>();
        this.data = new ArrayList<LinkedList<HashNode<K, V>>>();
        for (int i = 0; i < this.capacity; i++) {
            this.data.add(new LinkedList<HashNode<K,V>>());
        }
    }

    public Set<K> keySet() {
        return this.keySet;
    }

    public void put(K key, V val) {
        if (this.keySet.contains(key)) {
            // Look for the HashNode
            for (HashNode<K, V> node : this.data.get(getHash(key))) {
                if (node.getKey().equals(key)) {
                    node.setVal(val);
                    break;
                }
            }
        } else {
            this.data.get(getHash(key)).add(new HashNode<K, V>(key, val));
            this.keySet.add(key);
        }
    }

    public V get(K key) {
        if (this.keySet.contains(key)) {
            for (HashNode<K, V> node : this.data.get(getHash(key))) {
                if (node.getKey().equals(key)) {
                    return node.getVal();
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (K key : this.keySet) {
            sb.append(key.toString());
            sb.append(": ");
            for (HashNode<K, V> node : this.data.get(getHash(key))) {
                if (node.getKey().equals(key)) {
                    sb.append(node.toString());
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private int getHash(K key) {
        return (key.hashCode()) % this.capacity;
    }
}
