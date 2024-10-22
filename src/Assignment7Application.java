

public class Assignment7Application {

	public static class Assignment5ApplicationRefactored {

		public static void main(String[] args) {
	        CustomList<String> itemContents = new CustomArrayList<>();

	        // Add items to the list
	        itemContents.add("Element 1");
	        itemContents.add("Element 2");
	        itemContents.add("Element 3");

	        // Add an item at a specific index
	        itemContents.add(2, "Inserted Element");

	        // Print all items
	        for (int i = 0; i < itemContents.getSize(); i++) {
	            System.out.println(itemContents.get(i));
	        }

	        System.out.println("Removed Item: " + ((CustomArrayList<String>) itemContents).remove(2));

	        // Print all items after removal
	        System.out.println("After Removal:");
	        for (int i = 0; i < itemContents.getSize(); i++) {
	            System.out.println(itemContents.get(i));
	        }
	    }
	}
}
