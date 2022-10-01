package genericSet;

public class Tester {

	public static void main(String[] args) {

		//Test the GenericSet with integers
		GenericSet<Integer> numbers1 = new GenericSet<Integer>();
		
		//testing the add method
		numbers1.add(3);
		numbers1.add(6);
		numbers1.add(8);
		numbers1.add(9);
		
		//Test the resize method --Works
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
		numbers1.remove(7);
		System.out.println(numbers1.toString());
		System.out.println();
		
		//Test the remove
		numbers1.remove(20);
		System.out.println(numbers1.toString());
		System.out.println();
		
		//Test the remove
		numbers1.remove(5);
		System.out.println(numbers1.toString());
		System.out.println();

		//test for existing value
		System.out.println(numbers1.exist(10));
		System.out.println();
		
		//test for non-existing value
		System.out.println(numbers1.exist(2));
		//System.out.println();
		
		//test addAll --doesn't work
		Integer[] list1 = new Integer[2];
		list1[0] = 30;
		list1[1] = 31;
		
		numbers1.addAll(list1);
		System.out.println(numbers1.toString());
		//System.out.println();
		
		//test remove all 
		Integer[] list2 = new Integer[3];
		list2[0] = 12;
		list2[1] = 14;
		list2[2] = 31;
		numbers1.removeAll(list2);
		System.out.println(numbers1.toString());
		
		//test get 
		System.out.println(numbers1.get(7));
	}
}
