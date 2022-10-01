package genericSet;

public class GenericSet<E extends Comparable<E>>{
	//data fields
	//set cannot have two of the same value
	private E[] set;
	private int size = 0; //represents number of elements in the set
	
	public GenericSet() {
		this.set = (E[])(new Comparable[10]);
	}
	
	public GenericSet(int capacity) {
		this.set = (E[])(new Comparable[capacity]);
	}
	
	public GenericSet(E... values) {
		fiterDuplicates(values);
		
		while(values.length >= this.set.length) {
			resize();
		}
		
		//add all the values in the array
		for(int i = 0; i < this.set.length; i++) {
			this.set[i] = values[i];
			addValue();
		}
	}
	
	//fix deep copy constructor
//	public GenericSet(GenericSet set) { 
//		for(int i = 0; i < this.set.length; i++) {
//			set = this.set[i];
//		}
//	}

	//check if value exist
	public boolean exist(E value) {
		for(int i = 0; i < set.length; i++) {
			if(set[i]== null) {
				//do nothing
			} else if(set[i].compareTo(value) == 0){
				return true;
			}
		}
		return false;
	}
	
	//add value to set
	public void add(E value) {
		//if value doesn't exist add it
		if(!exist(value)) {
			//resize if array gets full
			if(size ==  set.length) {
				set = resize();
				set[size] = value;
				addValue();
			} else {
				set[size] = value;
				addValue();
			}
		}
	}
	
	public void addAll(E... values) {
		for(int i = 0; i < values.length; i++) {
			if(!exist(values[i])) {
				add(values[i]);
			}
		}
	}
	
	public void remove(E value) {
		if(size == 1 && exist(value)) {
			set[0] = null;
			size--;
		}
		if(exist(value)) {
			int hold = 0;
			for(int i = 0; i < set.length; i++) {
				if(set[i] != null && set[i].compareTo(value) == 0) {
					set[i] = null;
					hold = i;
				}
			}

			leftRotate(set, hold);
			size--;
		}
	}

	//left rotate
	void leftRotate(E[] set, int index) {
		E[] temp = (E[])(new Comparable[set.length]);
		
		//copying elements after index into temp
		int count = 0;
		for(int i = index + 1; i < set.length; i++) {
			if (count < size) {
				temp[count] = set[i];
				count++;
			}
		}
		
		int traverse = 0;
		for(int i = index; i < set.length; i++) {
			if (traverse < count) {
				set[i] = temp[traverse];
				traverse++;
			}
		}
	}


	public void removeAll(E... values) {
		if(size == 1) {
			for(int i = 0; i < set.length; i++) {
				if(exist(values[i])) {
					set[0] = null;
					size--;
				}
			}
		}
		
		for(int i = 0; i < values.length; i++) {
			if(exist(values[i])) {
				int hold = 0;
				for(int j = 0; j < set.length; j++) {
					if(set[j] != null && set[j].compareTo(values[i]) == 0) {
						set[j] = null;
						hold = j;
					}
				}
				leftRotate(set, hold);
				size--;
			}
		}
	}
	
	public E get(int index) {
		if(set[index] != null) {
			return set[index];
		}
		return null;
	}
	
	private void fiterDuplicates(E[] set) {
		E[] temp = (E[])(new Comparable[set.length]);
		
		int setLen = this.set.length;
		int j = 0;
		
		if(set.length == 0 || set.length == 1) {
			this.set = set;
		}
		
		for(int i = 0; i < set.length - 1; i++) {
			if(set[i].compareTo(set[i + 1]) != 0) {
				temp[j++] = set[i];
			}
		}
		
		temp[j++] = set[setLen - 1];
		
		//changing original array
		for(int i = 0; i < j; i++) {
			set[i] = temp[i];
		}
	}
	
	private E[] resize() {
		int size = set.length * 2;
		E[] newSet = (E[])(new Comparable[size]);
		
		for(int i = 0; i < set.length; i++) {
			newSet[i] = this.set[i];
		}
		return newSet;
	}
	
	//increase size
	public void addValue() {
		this.size++;
	}
	
	//decrease size
	public void removeValue() {
		this.size--;
	}
	
	public int size() {
		this.size = 0;
		for (int i = 0; i < this.set.length; i++) {
			if (set[i] != null) {
				size++;
			}
		}
		return size;
	}
	
	public String toString() {
		int value = 0;
		String setValues = "";
		int setLength = this.set.length;


		for (int i = 0; i < set.length; i++) {
			if (set[i] != null) {
				value++;
			}

			if (i < set.length - 1) {
				setValues = setValues + set[i] + ", " ;
			}
			else if (i == set.length - 1) {
				setValues += set[i];
			}

		}

		if (value == 0) {
			return "{}";
		}



		return "{" + setValues  + "}";

	}
}
