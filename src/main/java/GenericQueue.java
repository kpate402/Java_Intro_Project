
public class GenericQueue<T> extends GenericList<T> {
	
	private Node<T> tail;
	
	// GenericQueue Constructor:
	GenericQueue(T val){
		super(val);
		tail = super.getHead();
	}
	
	public Node<T> getTail() {
		return tail;
	}
	
	public void setTail(Node<T> x) {
		tail = x;
	}
	
	// remove last node and return its data
	public T removeTail() {
		T data;
		if(super.getHead() == null) {  // if list is empty return null
			return null;
		} 
		if(super.getHead() == tail) {  // if list has 1 element 
			data = tail.getVal();
			super.setHead(null);
			tail = null;
			super.setLength(super.getLength()-1);
			return data;
		}
		
		// if list has more than 1 element
		data = tail.getVal();
		Node<T> temp = super.getHead();
		while(temp.getNext() != tail) {
			
			temp = temp.getNext();
		}
		tail = null;
		tail = temp;
		super.setLength(super.getLength()-1);
		return data;
	}
	
	// add(): add node to back of list
	@Override
	void add(T data) {
		Node<T> insert = new Node<T>(data);
		if(super.getHead() == null) {  // if list is empty update head and tail
			super.setHead(insert);
			tail = insert;
			super.setLength(super.getLength()+1);
			
		} else if(super.getHead() == tail) {  // if list has 1 element update head->next
			super.getHead().setNext(insert);
			tail = insert;
			super.setLength(super.getLength()+1);
		}else {// if list has more than 1 element
			tail.setNext(insert);
			tail = insert;
			super.setLength(super.getLength()+1);
		}
	}
	
	//enqueue(); method of adding to queue specific to queue
	public void enqueue(T data) {
		add(data);
	}
	
	//dequeue(); method of deleting to queue specific to queue
	public T dequeue() {
		return delete();
	}

}
