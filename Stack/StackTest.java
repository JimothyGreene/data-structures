package Stack;

import static org.junit.Assert.*;
import org.junit.Test;

public class StackTest {
    @Test
    public void emptyTest() {
        Stack<Integer> s = new Stack<>();
        assertTrue(s.isEmpty());
    }

    @Test
    public void pushTest() {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        s.push(5);
        s.push(3);
        assertFalse(s.isEmpty());
    }

    @Test
    public void popTest() {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        s.push(5);
        s.push(3);
        assertFalse(s.isEmpty());
        assertEquals(Integer.valueOf(3), s.pop());
        assertEquals(Integer.valueOf(5), s.pop());
        assertEquals(Integer.valueOf(0), s.pop());
        assertTrue(s.isEmpty());
    }

    @Test
    public void peekTest() {
        Stack<Integer> s = new Stack<>();
        s.push(0);
        s.push(5);
        s.push(3);
        assertEquals(Integer.valueOf(3), s.peek());
        assertFalse(s.isEmpty());
    }
}
