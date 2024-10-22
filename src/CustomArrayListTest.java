import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CustomArrayListTest {

    @Test
    public void testAddItem() {
        CustomList<String> list = new CustomArrayList<>();
        
        // Add items to the list
        list.add("Item 1");
        list.add("Item 2");
        
        // Assert that the size is correct and the items are added correctly
        assertEquals(2, list.getSize());
        assertEquals("Item 1", list.get(0));
        assertEquals("Item 2", list.get(1));
    }

    @Test
    public void testAddItemAtIndex() {
        CustomList<String> list = new CustomArrayList<>();
        
        // Add items to the list
        list.add("Item 1");
        list.add("Item 3");
        
        // Insert an item at index 1
        list.add(1, "Item 2");
        
        // Assert that the items are added correctly at the right indices
        assertEquals(3, list.getSize());
        assertEquals("Item 1", list.get(0));
        assertEquals("Item 2", list.get(1));
        assertEquals("Item 3", list.get(2));
    }

    @Test
    public void testAddItemAtInvalidIndex() {
        CustomList<String> list = new CustomArrayList<>();
        
        // Try adding at an invalid index
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(1, "Item 1");  // Index 1 is out of bounds for an empty list
        });
    }

    @Test
    public void testGetItem() {
        CustomList<String> list = new CustomArrayList<>();
        
        // Add some items
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");

        // Assert that the correct items are returned for valid indices
        assertEquals("Item 1", list.get(0));
        assertEquals("Item 2", list.get(1));
        assertEquals("Item 3", list.get(2));
    }

    @Test
    public void testGetItemAtInvalidIndex() {
        CustomList<String> list = new CustomArrayList<>();
        
        // Add some items
        list.add("Item 1");
        list.add("Item 2");

        // Try getting an item at an invalid index
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(2);  // Index 2 is out of bounds since the size is 2
        });
    }

    @Test
    public void testRemoveItem() {
        CustomList<String> list = new CustomArrayList<>();
        
        // Add some items
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");

        // Remove the item at index 1 ("Item 2")
        String removedItem = list.remove(1);

        // Assert that the correct item was removed and the list is updated correctly
        assertEquals("Item 2", removedItem);
        assertEquals(2, list.getSize());
        assertEquals("Item 1", list.get(0));
        assertEquals("Item 3", list.get(1));
    }

    @Test
    public void testRemoveItemAtInvalidIndex() {
        CustomList<String> list = new CustomArrayList<>();
        
        // Add some items
        list.add("Item 1");
        list.add("Item 2");

        // Try removing an item at an invalid index
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(2);  // Index 2 is out of bounds
        });
    }

    @Test
    public void testResizeArray() {
        CustomList<String> list = new CustomArrayList<>();
        
        // Add items to the list until it resizes
        for (int i = 0; i < 11; i++) {
            list.add("Item " + i);
        }

        // Assert that the list has resized and the size is correct
        assertEquals(11, list.getSize());
        assertEquals("Item 10", list.get(10));
    }

    @Test
    public void testSizeAfterRemove() {
        CustomList<String> list = new CustomArrayList<>();
        
        // Add some items
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");

        // Remove an item and check the size
        list.remove(1); // Remove "Item 2"
        assertEquals(2, list.getSize());
        
        // Assert the correct remaining items are in the list
        assertEquals("Item 1", list.get(0));
        assertEquals("Item 3", list.get(1));
    }

    @Test
    public void testEmptyListSize() {
        CustomList<String> list = new CustomArrayList<>();
        
        // Assert that an empty list has size 0
        assertEquals(0, list.getSize());
    }
}