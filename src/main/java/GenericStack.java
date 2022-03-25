
public class GenericStack<T> extends GenericList<T>{
	private Node<T> tail;
	
	GenericStack(T val){
		super(val);
		tail = super.getHead();
	}
	
	public Node<T> getTail() {
		return tail;
	}
	
	public void setTail(Node<T> x) {
		tail = x;
	}
	
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
	
	@Override
	void add(T data) {
		Node<T> insert = new Node<T>(data);
		if(super.getHead() == null) {  // if list is empty update head and tail
			super.setHead(insert);
			tail = insert;
			super.setLength(super.getLength()+1);
			
		} else if(super.getHead() == tail) {  // if list has 1 element update head->next
			
			insert.setNext(tail);
			super.setHead(insert);
			super.setLength(super.getLength()+1);
		}else {// if list has more than 1 element
			insert.setNext(super.getHead());
			super.setHead(insert);
			super.setLength(super.getLength()+1);
		}
	}
	
	//push(); method of adding to stack specific to stack
	public void push(T data) {
		add(data);
	}
		
	//pop(); method of deleting in stack specific to stack
	public T pop() {
		return delete();
	}
}
