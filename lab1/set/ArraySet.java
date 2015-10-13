package set;

import java.util.ArrayList;
import java.util.Iterator;

public class ArraySet<E> implements SimpleSet<E> {
	private ArrayList<E> set;

	/**
	 * Constructs a new empty set.
	 */
	public ArraySet() {
		set = new ArrayList<E>();
	}

	/**
	 * Adds the specified element to this set, if it is not already present.
	 * post: x is added to the set if it is not already present
	 * 
	 * @param x
	 *            the element to be added
	 * @return true if the specified element was added
	 */
	public boolean add(E x) {
		if (!set.contains(x)) {
			set.add(x);
			return true;
		}
		return false;
	}

	/**
	 * Removes the specified element from this set if it is present. post: x is
	 * removed if it was present
	 * 
	 * @param x
	 *            the element to remove - if present
	 * @return true if the set contained the specified element
	 */
	public boolean remove(Object x) {
		if (set.contains(x)) {
			set.remove(x);
			return true;
		}
		return false;
	}

	/**
	 * Returns true if this set contains the specified element.
	 * 
	 * @param x
	 *            the element whose presence is to be tested
	 * @return true if this set contains the specified element
	 */
	public boolean contains(Object x) {
		if (set.contains(x)) {
			return true;
		}
		return false;
	}

	/**
	 * Returns true if this set contains no elements.
	 * 
	 * @return true if this set contains no elements
	 */
	public boolean isEmpty() {
		if (set.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the number of elements in this set.
	 * 
	 * @return the number of elements in this set
	 */
	public int size() {
		if (set.isEmpty()) {
			return 0;
		}
		return set.size();
	}

	/**
	 * Returns an iterator over the elements in this set.
	 * 
	 * @return an iterator over the elements in this set
	 */
	public Iterator<E> iterator() {
//		if (!set.isEmpty()) {
			return set.iterator();
//		}
//		return null;
	}

	/**
	 * Adds all of the elements in the specified set, for which it is possible,
	 * to this set. post: all elements, for which it is possible, in the
	 * specified set are added to this set.
	 * 
	 * @return true if this set has changed as a result of the call
	 */
	public boolean addAll(SimpleSet<? extends E> s) {
		Iterator<? extends E> itr = s.iterator();
		int temp = set.size();
		while (itr.hasNext()) {
			add(itr.next());
		}
		if(set.size()==temp){
			return false;
		}
		
		return true;
		
	}
}
