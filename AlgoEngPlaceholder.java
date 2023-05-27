// --== CS400 Project One File Header ==--
// Name: Harshet Anand
// CSL Username: harshet
// Email: hanand2@wisc.edu
// Lecture #: 002 @2:30pm

import java.util.NoSuchElementException; // Import used for error when element not found
import java.util.Iterator;
import java.util.LinkedList; // Import used for linked lists

/**
 * 
 * @author Harshet Anand
 *
 *         This class is a data structure that implements a hashtable and uses
 *         chaining to handle has collisions.
 */

public class AlgoEngPlaceholder<KeyType, ValueType> implements IterableMapADT<KeyType, ValueType> {
	private int capacity; // The size of the hashtable
	private int sizeOfValues; // The size of the number of values in the hashtable
	protected LinkedList<Object[]>[] hashtable; // Creates a linked list with objects stored
	private HashNode<KeyType, ValueType> Map[];

	/**
	 * This constructor creates a new hashnode in the map and sets the number of
	 * values to 0 to begin with.
	 * 
	 * @param capacity size of the hashtable map
	 */
	@SuppressWarnings("unchecked")
	public AlgoEngPlaceholder(int capacity) {
		Map = (HashNode<KeyType, ValueType>[]) new HashNode[capacity];
		this.capacity = capacity;
		sizeOfValues = 0;
	}

	/**
	 * This constructor sets the default capacity of the hashnode to 15 with the
	 * number of values set to 0 to begin with.
	 */
	@SuppressWarnings("unchecked")
	public AlgoEngPlaceholder() { // with default capacity = 15
		Map = (HashNode<KeyType, ValueType>[]) new HashNode[15];
		this.capacity = 15;
		sizeOfValues = 0;
	}

	/**
	 * Inserts a new (key, value) pair into the map if the map does not contain a
	 * value mapped to key yet. The hashtable will grow by doubling its capacity and
	 * rehashing, whenever its load factor becomes greater than or equal to 70%.
	 * 
	 * @param key   the key of the (key, value) pair to store
	 * @param value the value that the key will map to
	 * @return true if the (key, value) pair was inserted into the map, false if a
	 *         mapping for key already exists and the new (key, value) pair could
	 *         not be inserted or if the key is null
	 */
	@Override
	public boolean put(KeyType key, ValueType value) {
		HashNode<KeyType, ValueType> origNode = new HashNode<KeyType, ValueType>(key, value);
		int list = hashIndex(key);

		// 1) Returns false if the key is null or 2) If key already exists
		if (key == null || containsKey(key)) {
			return false;
		}

		// 2) Adds a node if the list is empty
		if (Map[list] == null) {
			Map[list] = origNode;
		} else { // 3) Adds a node if the list is not empty by moving the node to the end and
					// changing it to the new node
			HashNode<KeyType, ValueType> endNode = Map[list];
			while (!(endNode == null)) {
				if (endNode.getNext() == null) {
					endNode.setNext(origNode);
					break;
				}
				endNode = endNode.getNext();
			}
		}
		sizeOfValues++; // Increments number of values of keys

		if (loadFactor() >= 0.7) { // Load factor is set to greater than or equal to 70%
			resize();
		}
		return true;
	}

	/**
	 * Returns the value mapped to a key if the map contains such a mapping.
	 * 
	 * @param key the key for which to look up the value
	 * @return the value mapped to the key
	 * @throws NoSuchElementException if the map does not contain a mapping for the
	 *                                key
	 */
	@Override
	public ValueType get(KeyType key) throws NoSuchElementException {
		ValueType returnValue = null;
		int index = hashIndex(key);

		// 1) Returns exception with error message if a key is not found
		if (containsKey(key) == false) {
			throw new NoSuchElementException("Error! No such element found!");
		}

		// 2) Chaining to find key and return the value of the key when found
		HashNode<KeyType, ValueType> nextNode = Map[index];
		while (!(nextNode == null)) {
			if (!(nextNode.getKey() != key)) {
				return nextNode.getValue();
			}
			nextNode = nextNode.getNext();
		}
		return returnValue; // Returns value mapped to key
	}

	/**
	 * Removes a key and its value from the map.
	 * 
	 * @param key the key for the (key, value) pair to remove
	 * @return the value for the (key, value) pair that was removed, or null if the
	 *         map did not contain a mapping for key
	 */
	@Override
	public ValueType remove(KeyType key) {
		int indexOfHash = hashIndex(key);

		// 1) Returns false if key does not exist or 2) If index is null
		if (!(containsKey(key) != false) || !(Map[indexOfHash] != null)) {
			return null;
		}

		HashNode<KeyType, ValueType> newNode = Map[indexOfHash];
		ValueType returnValue = null;

		// 2) Retrieves key of the first node and stores value of node to respective key
		if (key.equals(newNode.getKey())) {
			returnValue = newNode.getValue();

			// 3) Replaces next node with new node
			if (!(newNode.getNext() == null)) {
				newNode = newNode.getNext();
			} else { // 4) Sets remaining nodes to null
				Map[indexOfHash] = null;
			}
			sizeOfValues = sizeOfValues - 1; // Decrements size of values when set to null
			return returnValue;
		}

		HashNode<KeyType, ValueType> nextNode = newNode.getNext();

		// 5) Retrieves next node that is not null and does not equal to the key
		while ((nextNode != null) && (!nextNode.getKey().equals(key))) {
			nextNode = nextNode.getNext();
			newNode = nextNode;
		}

		// Sets node that is not null to new node
		if (!(nextNode == null)) {
			newNode.setNext(nextNode.getNext());
			sizeOfValues = sizeOfValues - 1;
			return nextNode.getValue();
		}
		return returnValue; // Returns the value of the key, value pair
	}

	/**
	 * Checks if a key is stored in the map.
	 * 
	 * @param key the key to check for
	 * @return true if the key is stored (mapped to a value) by the map and false
	 *         otherwise
	 */
	@Override
	public boolean containsKey(KeyType key) {
		int index = hashIndex(key);

		HashNode<KeyType, ValueType> nextNode = Map[index];

		// Returns true if the node is not null and node contains key
		while (!(nextNode == null)) {
			if (key.equals(nextNode.getKey())) {
				return true;
			}
			nextNode = nextNode.getNext();
		}
		return false;
	}

	/**
	 * Returns the number of (key, value) pairs stored in the map.
	 * 
	 * @return the number of (key, value) pairs stored in the map
	 */
	@Override
	public int size() {
		return sizeOfValues; // Returns the size of the values
	}

	/**
	 * Removes all (key, value) pairs from the map.
	 */
	@Override
	public void clear() {
		for (int j = 0; j < sizeOfValues; j++) {
			hashtable[j].clear(); // For-loop that clears all pairs
		}
		sizeOfValues = 0; // Size set to zero once all pairs are cleared
	}

	// HELPER METHODS

	// These are the helper methods for getting and setting the key and value and
	// setting next the hashnode.
	private static class HashNode<KeyType, ValueType> {
		private KeyType key;
		private ValueType value;
		private HashNode nextHash;

		/**
		 * Retrieves value of key from the hashnode.
		 * 
		 * @param key   key set in the hashnode
		 * @param value number of keys set in the hashnode
		 */
		public HashNode(KeyType key, ValueType value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * Retrieves the value of the key from the hashnode.
		 * 
		 * @return value of the key from the hashnode
		 */
		public KeyType getKey() {
			return key;
		}

		/**
		 * Retrieves the value of the hashnode.
		 * 
		 * @return value of hashnode
		 */
		public ValueType getValue() {
			return value;
		}

		/**
		 * Retrieves the next hashnode.
		 * 
		 * @return next hashnode on the list
		 */
		public HashNode<KeyType, ValueType> getNext() {
			return nextHash;
		}

		/**
		 * Sets the value of the key of the hashnode.
		 * 
		 * @param key key set in the hashnode
		 */
		public void setKey(KeyType key) {
			this.key = key;
		}

		/**
		 * Sets the value of the hashnode.
		 * 
		 * @param value number of keys set in the hashnode
		 */
		public void setValue(ValueType value) {
			this.value = value;
		}

		/**
		 * Sets the next hashnode in the list.
		 * 
		 * @param next value of the next hashnode in the list
		 */
		public void setNext(HashNode<KeyType, ValueType> next) {
			this.nextHash = next;
		}

		/**
		 * Compares the key of hashnode and checks if it is equivalent to the other key.
		 * 
		 * @param key2 key to be compared to
		 * @return true if key is equal, false otherwise.
		 */
		public boolean equalKey(KeyType key2) {
			if (key2 == this.key) {
				return true;
			}
			return false;
		}
	}

	// These are the helper methods for finding the absolute integer of a number,
	// finding the hash index, finding the load factor, and growing the hashtable by
	// doubling its capacity and rehashing the values.

	/**
	 * This method returns the absolute value of a number.
	 * 
	 * @param number to be turned into absolute value
	 * @return the new absolute value of the original number
	 */
	private int absoluteValue(int number) {
		if (!(number >= 0)) {
			number = Math.abs(number);
		}
		return number;
	}

	/**
	 * This method needed to be given a key value and once it is provided, it
	 * returns the hash index of the key value.
	 * 
	 * @param key for hash index to be found
	 * @return absolute value of the hash index of the key
	 */
	private int hashIndex(KeyType key) {
		return absoluteValue(key.hashCode()) % capacity;
	}

	/**
	 * This method dynamically grows the hashtable by doubling its capacity and
	 * rehashing.
	 * 
	 * @return new capacity once resized
	 */
	private int resize() {
		int origCapacity = capacity;
		capacity = capacity * 2;

		HashNode<KeyType, ValueType> copyMap[] = Map.clone();
		HashNode<KeyType, ValueType>[]

		hashNode = (HashNode<KeyType, ValueType>[]) new HashNode[capacity];
		Map = hashNode;

		sizeOfValues = 0;

		for (int j = 0; j < origCapacity; j++) {
			HashNode<KeyType, ValueType> nextNode = copyMap[j];
			while (!(nextNode == null)) {
				put(nextNode.getKey(), nextNode.getValue());
				if (!(nextNode.getNext() != null)) {
					break;
				}
				nextNode = nextNode.getNext();
			}
		}
		return capacity;
	}

	/**
	 * This method calculates the load factor by taking the size of the values and
	 * dividing it by the capacity.
	 * 
	 * @return load factor once calculated
	 */
	private double loadFactor() {
		return (double) sizeOfValues / capacity;
	}

	@Override
	public Iterator<ValueType> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
