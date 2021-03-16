import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedListTest {
    @Test
    public void singlyEmptyTest() {
        LinkedList<Integer> ll = new SinglyLinkedList<>();
        assertEquals(0, ll.size());
        assertEquals("[]", ll.toString());
    }

    @Test
    public void doublyEmptyTest() {
        LinkedList<Integer> ll = new DoublyLinkedList<>();
        assertEquals(0, ll.size());
        assertEquals("[]", ll.toString());
    }

    @Test
    public void singlyFromArrayTest() {
        LinkedList<Integer> ll = new SinglyLinkedList<>(new Integer[] {0, 2, -1});
        assertEquals(3, ll.size());
        assertEquals(Integer.valueOf(0), ll.get(0));
        assertEquals(Integer.valueOf(2), ll.get(1));
        assertEquals(Integer.valueOf(-1), ll.get(2));
        assertEquals("[0, 2, -1]", ll.toString());
    }

    @Test
    public void doublyFromArrayTest() {
        LinkedList<Integer> ll = new DoublyLinkedList<>(new Integer[] {0, 2, -1});
        assertEquals(3, ll.size());
        assertEquals(Integer.valueOf(0), ll.get(0));
        assertEquals(Integer.valueOf(2), ll.get(1));
        assertEquals(Integer.valueOf(-1), ll.get(2));
        assertEquals("[0, 2, -1]", ll.toString());
    }

    @Test
    public void singlyAddAtIndexTest() {
        LinkedList<Integer> ll = new SinglyLinkedList<>();
        ll.add(0, 5);
        ll.add(0, 4);
        ll.add(0, 3);
        assertEquals(3, ll.size());
        assertEquals(Integer.valueOf(3), ll.get(0));
        assertEquals(Integer.valueOf(4), ll.get(1));
        assertEquals(Integer.valueOf(5), ll.get(2));
        assertEquals("[3, 4, 5]", ll.toString());
    }

    @Test
    public void doublyAddAtIndexTest() {
        LinkedList<Integer> ll = new DoublyLinkedList<>();
        ll.add(0, 5);
        ll.add(0, 4);
        ll.add(0, 3);
        assertEquals(3, ll.size());
        assertEquals(Integer.valueOf(3), ll.get(0));
        assertEquals(Integer.valueOf(4), ll.get(1));
        assertEquals(Integer.valueOf(5), ll.get(2));
        assertEquals("[3, 4, 5]", ll.toString());
    }

    @Test
    public void singlyGetTest() {
        LinkedList<Integer> ll = new SinglyLinkedList<>(new Integer[] {4, 3, 2, 1, 0});
        assertEquals(Integer.valueOf(4), ll.get(0));
        assertEquals(Integer.valueOf(3), ll.get(1));
        assertEquals(Integer.valueOf(2), ll.get(2));
        assertEquals(Integer.valueOf(1), ll.get(3));
        assertEquals(Integer.valueOf(0), ll.get(4));
    }

    @Test
    public void doublyGetTest() {
        LinkedList<Integer> ll = new DoublyLinkedList<>(new Integer[] {4, 3, 2, 1, 0});
        assertEquals(Integer.valueOf(4), ll.get(0));
        assertEquals(Integer.valueOf(3), ll.get(1));
        assertEquals(Integer.valueOf(2), ll.get(2));
        assertEquals(Integer.valueOf(1), ll.get(3));
        assertEquals(Integer.valueOf(0), ll.get(4));
    }

    @Test
    public void singlyFindTest() {
        LinkedList<Integer> ll = new SinglyLinkedList<>(new Integer[] {4, 3, 2, 1, 0});
        assertTrue(ll.find(3));
        assertTrue(ll.find(0));
        assertFalse(ll.find(-1));
        assertFalse(ll.find(45));
    }

    @Test
    public void doublyFindTest() {
        LinkedList<Integer> ll = new DoublyLinkedList<>(new Integer[] {4, 3, 2, 1, 0});
        assertTrue(ll.find(3));
        assertTrue(ll.find(0));
        assertFalse(ll.find(-1));
        assertFalse(ll.find(45));
    }

    @Test
    public void singlyRemoveTest() {
        LinkedList<Integer> ll = new SinglyLinkedList<>(new Integer[] {4, 3, 2, 1, 0});
        ll.remove(3);
        ll.remove(0);
        assertEquals(3, ll.size());
        assertFalse(ll.find(3));
        assertFalse(ll.find(0));
        assertEquals("[4, 2, 1]", ll.toString());
    }

    @Test
    public void doublyRemoveTest() {
        LinkedList<Integer> ll = new DoublyLinkedList<>(new Integer[] {4, 3, 2, 1, 0});
        ll.remove(3);
        ll.remove(0);
        assertEquals(3, ll.size());
        assertFalse(ll.find(3));
        assertFalse(ll.find(0));
        assertEquals("[4, 2, 1]", ll.toString());
    }

    @Test
    public void singlyRemoveAtTest() {
        LinkedList<Integer> ll = new SinglyLinkedList<>(new Integer[] {4, 3, 2, 1, 0});
        ll.removeAt(0);
        ll.removeAt(3);
        ll.removeAt(1);
        assertEquals(2, ll.size());
        assertFalse(ll.find(4));
        assertFalse(ll.find(0));
        assertFalse(ll.find(2));
        assertEquals("[3, 1]", ll.toString());
    }

    @Test
    public void doublyRemoveAtTest() {
        LinkedList<Integer> ll = new DoublyLinkedList<>(new Integer[] {4, 3, 2, 1, 0});
        ll.removeAt(0);
        ll.removeAt(3);
        ll.removeAt(1);
        assertEquals(2, ll.size());
        assertFalse(ll.find(4));
        assertFalse(ll.find(0));
        assertFalse(ll.find(2));
        assertEquals("[3, 1]", ll.toString());
    }

    @Test
    public void singlyAddAndRemoveTest() {
        LinkedList<Integer> ll = new SinglyLinkedList<>(new Integer[] {4, 3, 2, 1, 0});
        ll.removeAt(ll.size()-1);
        ll.add(5);
        ll.remove(4);
        ll.add(0, 6);
        assertEquals(5, ll.size());
        assertFalse(ll.find(0));
        assertFalse(ll.find(4));
        assertTrue(ll.find(5));
        assertTrue(ll.find(6));
        assertEquals("[6, 3, 2, 1, 5]", ll.toString());
    }

    @Test
    public void doublyAddAndRemoveTest() {
        LinkedList<Integer> ll = new DoublyLinkedList<>(new Integer[] {4, 3, 2, 1, 0});
        ll.removeAt(ll.size()-1);
        ll.add(5);
        ll.remove(4);
        ll.add(0, 6);
        assertEquals(5, ll.size());
        assertFalse(ll.find(0));
        assertFalse(ll.find(4));
        assertTrue(ll.find(5));
        assertTrue(ll.find(6));
        assertEquals("[6, 3, 2, 1, 5]", ll.toString());
    }
}
