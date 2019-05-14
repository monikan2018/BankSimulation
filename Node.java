/*****
 * Program to generate a node for queque.
 * Author :  Monika Nanda
 * Email Address: monikan@bu.edu
 * Class : Data Structures with Java
 * Programming Assignment 2
 * Last Modified: April 2, 2019
 */
public class Node<T> {
	private T data;
	private Node<T> next;
	
	public Node () {
	   data = null;
	   next =null;
	   
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
}
