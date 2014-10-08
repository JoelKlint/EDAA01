package map;

public class SimpleHashMap<K, V> implements Map<K, V> {
	Entry<K, V>[] table;
	private double loadFactor;
	private int capacity;

	/**
	 * Constructs an empty hashmap with the default initial capacity (16) and
	 * the default load factor (0.75).
	 */
	public SimpleHashMap() {
		capacity = 16;
		table = (Entry<K, V>[]) new Entry[capacity];
		loadFactor = 0.75;

	}

	/**
	 * Constructs an empty hashmap with the specified initial capacity and the
	 * default load factor (0.75).
	 */
	public SimpleHashMap(int capacity) {
		table = (Entry<K, V>[]) new Entry[capacity];
		loadFactor = 0.75;
		this.capacity = capacity;
	}

	public String show() {
		String result = "";

		for (int i = 0; i < capacity; i++) {
			result = result + i + "\t";

			Entry<K, V> temp = table[i];

			while (temp != null) {
				result = result + temp.toString() + " ";
				temp = temp.next;
			}
			result = result + "\n";
		}
		return result;
	}

	private static class Entry<K, V> implements Map.Entry<K, V> {
		K key;
		V value;
		private Entry<K, V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;

		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V v = this.value;
			this.value = value;
			return v;
		}

		public String toString() {
			return key + "=" + value;
		}

	}

	@Override
	public V get(Object key) {
		int i = index((K) key);
		Entry<K, V> temp = find(i, (K) key);
		if (temp != null) {
			return temp.getValue();
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		for (int i = 0; i < capacity; i++) {
			Entry<K, V> temp = table[i];

			if (temp != null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public V put(K key, V value) {

		Entry<K, V> temp = find(index(key), key);

		if (temp != null) {
			return temp.setValue(value);
		}

		temp = new Entry<K, V>(key, value);

		int index = index(key);
		temp.next = table[index];
		table[index] = temp;
		if (size() / capacity > loadFactor) {
			rehash();
		}
		return null;
	}

	private int index(K key) {
		return Math.abs(key.hashCode() % capacity);
	}

	private Entry<K, V> find(int index, K key) {
		Entry<K, V> temp = table[index];
		while (temp != null) {
			if (temp.key.equals(key)) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}

	private void rehash() {
		Entry<K, V>[] oldTable = table;
		capacity = capacity * 2;
		table = (Entry<K, V>[]) new Entry[capacity];
		for (int i = 0; i < oldTable.length; i++) {
			Entry<K, V> temp = oldTable[i];
			while (temp != null) {
				put(temp.key, temp.getValue());
				temp = temp.next;
			}
		}
	}

	@Override
	public V remove(Object key) {
		int temp = index((K) key);
		Entry<K, V> list = table[temp];
		if (list != null) {
			if (list.getKey().equals((K) key)) {
				table[temp] = list.next;
				list.next = null;
				return list.getValue();
			} else {
				while (list.next != null) {
					if (list.next.getKey().equals((K) key)) {
						V v = list.next.getValue();
						list.next = list.next.next;
						return v;
					}
					list = list.next;
				}
			}
		}
		return null;
	}

	@Override
	public int size() {
		int j = 0;
		for (int i = 0; i < capacity; i++) {
			Entry<K, V> temp = table[i];

			while (temp != null) {
				j++;
				temp = temp.next;
			}
		}
		return j;
	}

}
