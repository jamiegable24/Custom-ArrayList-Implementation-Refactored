
	public class CustomArrayList<T> implements CustomList<T> {
	    private Object[] items = new Object[10];  // Default capacity of 10
	    private int size = 0;  // Encapsulated size

	    @Override
	    public void add(T item) {
	        if (size == items.length) {
	            resizeArray();
	        }
	        items[size++] = item;
	    }

	    @Override
	    public boolean add(int index, T item) throws IndexOutOfBoundsException {
	        if (index < 0 || index > size) {
	            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for list size " + size);
	        }

	        if (size == items.length) {
	            resizeArray();
	        }

	        // Shift elements to the right starting from the end
	        for (int i = size; i > index; i--) {
	            items[i] = items[i - 1];
	        }

	        // Insert the new item at the specified index
	        items[index] = item;
	        size++;
	        return true;
	    }

	    @Override
	    public int getSize() {
	        return size;
	    }

	    @SuppressWarnings("unchecked")
	    @Override
	    public T get(int index) throws IndexOutOfBoundsException {
	        if (index < 0 || index >= size) {
	            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
	        }
	        return (T) items[index];
	    }

	    @Override
	    public T remove(int index) throws IndexOutOfBoundsException {
	        if (index < 0 || index >= size) {
	            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for list size " + size);
	        }

	        // Get the item to be removed
	        T removedItem = (T) items[index];

	        // Shift all elements after the removed element to the left
	        for (int i = index; i < size - 1; i++) {
	            items[i] = items[i + 1];
	        }

	        // Set the last element to null (optional, for cleanliness)
	        items[size - 1] = null;

	        size--;  // Decrease the size
	        return removedItem;
	    }

	    // Private helper method to resize the array
	    private void resizeArray() {
	        Object[] newArray = new Object[items.length * 2]; // Double the size of the array
	        System.arraycopy(items, 0, newArray, 0, items.length); // Efficient array copying
	        items = newArray; // Update reference to the new array
	    }
	
}