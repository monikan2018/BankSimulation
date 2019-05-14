/*****
 * Program creates methods to create and access Queue: to add,remove,check if empty, to peek at head, to get the size, set max size of queue
 * to print queue as string.
 * Author :  Monika Nanda
 * Email Address: monikan@bu.edu
 * Class : Data Structures with Java
 * Programming Assignment 2
 * Last Modified: April 2, 2019
 */
public class LQueue<T> {
		
	private Node<T> head;
	private Node<T> tail;
	private int count;
	
	public T remove() {
		if (isEmpty()) {
			return null;
		} else {
			T tmp = head.getData();
			if (count == 1) {
				// Now empty
				head = tail = null;
				count = 0;
			} else {
				head = head.getNext();
				count--;
			}
			return tmp;
		}
	}
	
	public boolean add(T data) {
		
		Node<T> n = new Node<T>();
		n.setData(data);
		n.setNext(null);
		
		if (count == 0) {
			head = tail = n;
			count = 1;
		} else {
			tail.setNext(n);
			tail = n;
			count++;
			
		}
		return true;
	}
	
	public boolean isEmpty() {
		return (count == 0);
	}
	
	
	public T peek() {
		if (isEmpty()) {
			return null;
		} else {
			return head.getData();
		}
	}
	
	public int size() {
		return count;
	}
	
	public int maxSize() {
		return Integer.MAX_VALUE;
	}
	
	public String toString() {
		String rtn = "head -> ";
		
		Node<T> tmp = head;
		while (tmp != null) {
			rtn += tmp.getData() + "\n";
			tmp = tmp.getNext();
		}
		
		return rtn;
	}

}
