package genericSet;

public class GenericSet<E extends Comparable<E>>{
	//data fields
	//set cannot have two of the same value
	private E[] set;
	private int index = 0; 
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
	
	public GenericSet(E set) {
		for(int i = 0; i < this.set.length; i++) {
			set = this.set[i];
		}
	}

	//check if value exist
	public boolean exist(E value) {
		for(int i = 0; i < set.length; i++) {
			if(set[i]== null) {
				return false;
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
			if(this.size >= set.length) {
				resize()[set.length + 1] = value;
				index++;
			} else {
				set[index] = value;
				index++;
				addValue();
			}
		}
//		for(int i = 0; i < this.set.length; i++) {
//			if(set[i] == null) {
//				set[i] = value;
//			}
//		}
	}
	
	public void addAll(E... values) {
		int index = 0;
		int valueIndex = 0;
		
		//find where the last value in the set is
		for (int i = 0; i < set.length; i++) {
			index++;
			if(set[i] != null) {
				index = i;
			}
		}
		
		//find out the length of the values
		for(int i = 0; i < values.length; i++) {
			valueIndex++;
		}
		
		//resize if the values being added will be out of bounds
		if ((index + valueIndex) >= set.length) {
			resize();
		}
		
		for(int i = index; i < set.length; i++) {
			int j = 0;
			if (!exist(values[i])) {
				set[i] = values[j];
			}
			j++;
		}
	}
	
	public void remove(E value) {
		E[] temp = (E[])(new Comparable[set.length]);
		int placeHolder = 0;
		int nullValue = 0;
		
		//check to see if value exist
		while(exist(value)) {
			for(int i = 0; i < set.length; i++) {
				//if value found equal that index to null
				if((set[i].compareTo(value)) == 0) {
					set[i] = null;
					placeHolder = i;
					break;
				}
			}
		}
		
		//shift element to the left
		for(int i = 0; i < set.length; i++) {
			if(i >= placeHolder && i < size - 1) {
				temp[i] = set[i + 1];
			} else {
				temp[i] = set[i];
			}
		}
		
		//make main set equal the shifted array
		for (int i = 0; i < set.length; i++) {
			set[i] = temp[i];
		}
		
		//find first null value for new set
		for(int i = 0; i < set.length; i++) {
			if(set[i] ==null) {
				nullValue = 1;
				index--;
				break;
			} else if (i >= set.length) {
				nullValue = set.length - 1;
			}
		}
		set[nullValue - 1] = null;
		removeValue();
	}
	
	public void removeAll(E... values) {
		int index = 0;
		int valueIndex = 0;
		
		//find where the last value in the set is 
		for(int i = 0; i < set.length; i++) {
			index++;
			if(set[i] != null) {
				index = i;
			}
		}
		
		//find out the length of the values
		for(int i = 0; i < values.length; i++) {
			valueIndex++;
		}
		
		//remove array if it matches the set
		for(int i = 0; i < set.length; i++) {
			if(exist(values[i])) {
				set[i] = null;
			}
		}
	}
	
	public E get(int index) {
		try {
			for(int i = 0; i < set.length; i++) {
				if(i == index) {
					return set[i];
				}
			}
		}
		catch(IndexOutOfBoundsException ex) {
			ex.printStackTrace();
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
		int size = this.set.length * 2;
		E[] newSet = (E[])(new Comparable[size]);
		
		for(int i = 0; i < this.set.length; i++) {
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
