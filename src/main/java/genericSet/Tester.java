package genericSet;

public class Tester {

	public static void main(String[] args) {

		//Test the GenericSet with integers
		GenericSet<Integer> numbers1 = new GenericSet<Integer>();
		
		//testing the add method
		System.out.println("Test add");
		numbers1.add(3);
		numbers1.add(6);
		numbers1.add(8);
		numbers1.add(9);
		System.out.println(numbers1.toString());
		System.out.println();
		
		//Test the resize method --Works
		System.out.println("Test resize");
		numbers1.add(10);
		numbers1.add(7);
		numbers1.add(12);
		numbers1.add(14);
		numbers1.add(17);
		numbers1.add(13);
		numbers1.add(20);
		numbers1.add(5);
		System.out.println(numbers1.toString());
		System.out.println();
		
		//Test the remove
		System.out.println("Test remove: remove 7 from the list");
		numbers1.remove(7);
		System.out.println(numbers1.toString());
		System.out.println();
		
		//Test the remove
		System.out.println("Test remove: remove 20 from the list");
		numbers1.remove(20);
		System.out.println(numbers1.toString());
		System.out.println();
		
		//Test the remove
		System.out.println("Test remove: remove 5 from the list");
		numbers1.remove(5);
		System.out.println(numbers1.toString());
		System.out.println();

		//test for existing value
		System.out.println("Test exist: check if 10 exist within the list");
		System.out.println(numbers1.exist(10));
		System.out.println();
		
		//test for non-existing value
		System.out.println("Test exist: check if 2 exist within the list");
		System.out.println(numbers1.exist(2));
		System.out.println();
		
		//test addAll
		System.out.println("Test addAll: add a Integer Array {30, 31}");
		Integer[] list1 = new Integer[2];
		list1[0] = 30;
		list1[1] = 31;
		
		numbers1.addAll(list1);
		System.out.println(numbers1.toString());
		System.out.println();
		
		//test remove all 
		System.out.println("Test removeAll: Integer Array {12, 14, 31}");
		Integer[] list2 = new Integer[3];
		list2[0] = 12;
		list2[1] = 14;
		list2[2] = 31;
		numbers1.removeAll(list2);
		System.out.println(numbers1.toString());
		System.out.println();
		
		//test get 
		System.out.println("Test get: remove value from index 7");
		System.out.println("Index " + 7 + " is " +numbers1.get(7));
		
		//make deep copy of numbers1
//		GenericSet<Integer> numbers1Copy = new GenericSet<Integer>(numbers1);
//		System.out.println(numbers1Copy.get(0));
//		
//		//make changes to numbers1Copy
//		numbers1Copy.add(99);
//		numbers1Copy.add(100);
//		
//		//check if number1Copy is truely a deep copy
//		System.out.println("Original list");
//		System.out.println(numbers1.toString());
//		
//
//		System.out.println("Deep copy list");
//		System.out.println(numbers1.toString());
	}
}
