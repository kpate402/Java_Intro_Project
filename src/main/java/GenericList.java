import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public abstract class GenericList<T> implements Iterable<T> {

	private int length;
	private Node<T> head;
	
	// Basic Node inner class
	class Node<T> {
		private T data;
		private Node<T> next;
		
		// Node Constructor: 
		public Node(T val) {
			data = val;
			next = null;
		}
		
		// Getter for data 
		public T getVal() {
			return data;
		}
		// Getter for Next
		public Node<T> getNext() {
			return next;
		}
		
		// Setter for data
		public void setVal(T val) {
			data = val;
		}
		
		// Setter for Next
		public void setNext(Node<T> x) {
			next = x;
		}
		
	}
	
	// GenericList Constructor: 
	GenericList(T val){
		this.head = new Node<T>(val);
		this.length = 1;
	}
	
	// Getter for head
	public Node<T> getHead() {
		return head;
	}
	
	// Setter for Head
	public void setHead(Node<T> x) {
		head = x;
	}
	
	// Getter for length
	public int getLength() {
		return length;
	}
	
	// Setter for length
	public void setLength(int size) {
		length = size;
	}
		
	// print():  prints list
	public void print() {
		if (head == null) {
			System.out.println("Empty List");
		}
		Node<T> temp = head; 
		while (temp != null) {
			System.out.println(temp.getVal());
			temp = temp.getNext();
		}
	}
	
	// abstract method add(): done in child class
	abstract void add(T data);
	
	// delete(); delete a node and return its value
	public T delete() {
		if(head == null) {
			return null;
		}
		T data = head.getVal();
		Node<T> temp = head.getNext();
		head = null;
		head = temp;
		
		length--;
		return data;
	}
	
	// dumpList(): returns an ArrayList with all 
	// values in current list and clears list
	public ArrayList<T> dumpList() {
		
		ArrayList<T> dump = new ArrayList<T>();
		Node<T> temp = head;
		while (temp != null) {
			dump.add(this.delete());
			temp = temp.getNext();
		}
		length = 0;
		return dump;
	}
	
	// get(): returns value at a specific index
	// or null
	public T get(int index) {
		int i = 0;
		Node<T> temp = head;
		while (temp != null) {
			if( i == index) {
				return temp.getVal();
			}
			
			temp = temp.getNext();
			i++;
		}
		return null;
	}
	
	// set(): returns value at a specific index
	// and replaces that value with another or
	// if index is out of bounds return null
	public T set(int index, T element) {
		int i = 0;
		Node<T> temp = head;
		while (temp != null) {
			if( i == index) {
				T prevElem = temp.getVal();
				temp.setVal(element);
				return prevElem;
			}
			
			temp = temp.getNext();
			i++;
		}
		return null;
	}
	
	//iterator(): returns a iterator for the class
	public Iterator<T> iterator() {
		GLLIterator<T> iter = new GLLIterator<T>(head);
		return iter;
	}
	
	//
	public Iterator<T> descendingIterator() {
		ReverseGLLIterator<T> iter = new ReverseGLLIterator<T>(head);
		return iter;
	}
	
	public ListIterator<T> listIterator( int index) {
		GLListIterator<T> iter = new GLListIterator<T>(index,head);
		return iter;
	}

}















