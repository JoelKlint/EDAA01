package queue;

import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		size = 0;
	}

	/**
	 * Returns an iterator over the elements in this queue
	 * 
	 * @return an iterator over the elements in this queue
	 */
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;

		private QueueIterator() {
			if (size == 0) {
				pos = null;
			} else {
				pos = last.next;
			}
		}

		public boolean hasNext() {
			if (pos == null) {
				return false;
			}
			return true;
		}

		public E next() {
			if (hasNext()) {
				QueueNode<E> temp = pos;
				pos = pos.next;
				if (pos == last.next) {
					pos = null;
				}
				return temp.element;
			} else {
				throw new NoSuchElementException();
			}

		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Inserts the specified element into this queue, if possible post: The
	 * specified element is added to the rear of this queue
	 * 
	 * @param x
	 *            the element to insert
	 * @return true if it was possible to add the element to this queue, else
	 *         false
	 */
	public boolean offer(E x) {
		QueueNode<E> a = new QueueNode<E>(x);
		size++;
		if (last == null) {
			last = a;
			a.next = a;
		} else {
			a.next = last.next;
			last.next = a;
			last = a;
		}
		return true;
	}

	/**
	 * Retrieves and removes the head of this queue, or null if this queue is
	 * empty. post: the head of the queue is removed if it was not empty
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public E poll() {
		if (last == null) {
			return null;
		} else if (size == 1) {
			size--;
			QueueNode<E> temp = last.next;
			last = null;
			return temp.element;
		} else if (size == 2) {
			size--;
			QueueNode<E> temp = last.next;
			last.next = last;
			return temp.element;
		} else {
			size--;
			QueueNode<E> temp = last.next;
			last.next = last.next.next;
			return temp.element;
		}
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, returning null if
	 * this queue is empty
	 * 
	 * @return the head element of this queue, or null if this queue is empty
	 */
	public E peek() {
		if (size == 0) {
			return null;
		}
		return last.next.element;
	}

	public void append(FifoQueue<E> q) {
		// Om båda listorna inte är tomma
		if (size > 0 && q.size > 0) {
			size = size + q.size;
			QueueNode<E> temp = q.last.next;
			q.last.next = last.next;
			last.next = temp;
			last = q.last;
		}
		// Om q är tom
		else if (q.size == 0) {
		}
		// Om den aktuella listan är tom
		else if (size == 0 && q.size > 0) {
			last = q.last;
			size = q.size;
			Iterator<E> i = q.iterator();
		}
		q.last = null;
		q.size = 0;
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}

	}

}
