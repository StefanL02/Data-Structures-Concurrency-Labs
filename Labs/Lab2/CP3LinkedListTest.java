package Lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;public class CP3LinkedListTest {

    private CP3LinkedList<Integer> list;

    //Q3 JUnit testing
    @BeforeEach
    public void setUp() {
        // This method is run before each test
        list = new CP3LinkedList<>();
    }

    @Test
    public void testAddFirstAndSize() {
        assertEquals(0, list.size());  //Initial size should be 0

        list.addFirst(10);
        assertEquals(1, list.size());  // After adding one element, size should be 1

        list.addFirst(20);
        list.addFirst(30);
        assertEquals(3, list.size());  // After adding two more elements, size should be 3
    }

    @Test
    public void testGetFirst() {
        list.addFirst(10);
        list.addFirst(20);
        assertEquals(20, list.getFirst());  // The first element should be 20

        list.addFirst(30);
        assertEquals(30,list.getFirst());  //The first element should be 30
    }

    @Test
    public void testRemoveFirst() {
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        assertEquals(30, list.removeFirst());  // Remove first element (30)
        assertEquals(20, list.getFirst());     // Now first element should be 20
        assertEquals(2, list.size());          // Size should decrease
    }

    @Test
    public void testContains() {
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        assertTrue(list.contains(20));         // List should contain 20
        assertFalse(list.contains(40));        // List should not contain 40
    }

    @Test
    public void testRemoveFromEmptyListThrowsException() {
        assertThrows(NoSuchElementException.class, () -> {
            list.removeFirst();                // This should throw an exception, can't remove from empty list
        });
    }

    //New tests
    @Test
    public void testAddLast() {
        list.addLast(10);
        assertEquals(10, list.getLast()); // Check the last element
        assertEquals(10, list.getFirst()); // First and last should be the same in a single-element list

        list.addLast(20);
        assertEquals(20, list.getLast()); // Check if the last element is updated
        assertEquals(10, list.getFirst()); // First element should remain the same

        list.addLast(30);
        assertEquals(30, list.getLast()); // Check if the last element is updated
        assertEquals(10, list.getFirst()); // First element should remain the same
    }

    @Test
    public void testRemoveLast() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30); // List is now 10 -> 20 -> 30

        assertEquals(30, list.removeLast()); //Last element should be 20 now
        assertEquals(20, list.getLast());    //Check the last element

        assertEquals(20, list.removeLast()); //Last element should now be 10
        assertEquals(10, list.getLast());    //Check the last element

        assertEquals(10, list.removeLast()); //List should be empty
        assertThrows(NoSuchElementException.class, () -> list.getLast()); // Should throw exception
    }

    @Test
    public void testPrint() {
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Test forward print (expected order: 10, 20, 30)
        System.out.println("Expected print: 10, 20, 30");
        list.print();

        // Test reverse print (expected order: 30, 20, 10)
        System.out.println("Expected reverse print: 30, 20, 10");
        list.printReverse();
    }
    
}