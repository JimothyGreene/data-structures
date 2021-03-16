package Queue;

import static org.junit.Assert.*;
import org.junit.Test;

public class QueueTest {
    @Test
    public void emptyTest() {
        Queue<Integer> q = new Queue<>();
        assertTrue(q.isEmpty());
    }

    @Test
    public void enqueueTest() {
        Queue<Integer> q = new Queue<>();
        q.enqueue(0);
        q.enqueue(3);
        q.enqueue(5);
        assertFalse(q.isEmpty());
    }

    @Test
    public void dequeueTest() {
        Queue<Integer> q = new Queue<>();
        q.enqueue(0);
        q.enqueue(3);
        q.enqueue(5);
        assertEquals(Integer.valueOf(0), q.dequeue());
        assertEquals(Integer.valueOf(3), q.dequeue());
        assertEquals(Integer.valueOf(5), q.dequeue());
        assertTrue(q.isEmpty());
    }
}
