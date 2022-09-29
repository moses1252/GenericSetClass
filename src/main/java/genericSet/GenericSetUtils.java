package genericSet;

public class GenericSetUtils extends GenericSet {
	
	private GenericSetUtils() {
		
	}
	
	@SuppressWarnings("unchecked")
	public static <E> GenericSet union(final E[] value1, final E[] value2) {
		return new GenericSet() {{
			addAll((Comparable[]) value1);
			addAll((Comparable[]) value2);
		}};
	}
	
	public static <E> E[] intersection(E[] set1, E[] set2) {
		//count matching values
		int set3Index = 0;
		for(int i = 0; i < set1.length; i++) {
			if(set2.equals(set1[i])) {
				set3Index++;
			}
		}
		
		E[] set3 = (E[])(new Comparable[set3Index]);
		int position = 0;
		for (int i = 0; i < set1.length; i++) {
			if (set2.equals(set1[i])) {
				set3[position++] = set1[i];
			}
		}
		return set3;
	}
	
	public static <E> boolean disjoint(E[] set1, E[] set2) {
		int count = 0;
		for(int i = 0; i < set1.length; i++) {
			if(set2.equals(set1[i])) {
				count++;
			}
		}
		
		if(count == 0) {
			return true;
		}
		
		return false;
	}

}
