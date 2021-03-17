package HashMap;

import static org.junit.Assert.*;
import org.junit.Test;

public class HashMapTest {
    @Test
    public void emptyTest() {
        HashMap<String, Integer> hm = new HashMap<>();
        assertEquals(0, hm.keySet().size());
    }

    @Test
    public void putTest() {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("A", 5);
        hm.put("B", 6);
        hm.put("A", 7);
        assertEquals(2, hm.keySet().size());
        assertEquals("A: 7\nB: 6\n", hm.toString());
    }

    @Test
    public void getTest() {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("A", 5);
        hm.put("B", 6);
        hm.put("A", 7);
        assertEquals(Integer.valueOf(7), hm.get("A"));
        assertEquals(Integer.valueOf(6), hm.get("B"));
    }
}
