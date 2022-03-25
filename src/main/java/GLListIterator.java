import java.util.ListIterator;

public class GLListIterator<E> implements ListIterator<E> {
	private GenericList<E>.Node<E> node;
	private GenericList<E>.Node<E> head;
	private int index;
	
	// GLListIterator Constructor:
	GLListIterator(int i, GenericList<E>.Node<E> Head) {
		node = Head;
		head = Head;
		int pos = 0;
		while (node.getNext() != null && i != pos) {
			
			node = node.getNext();
			pos++;
		}
		index = i;

	}
	
	//hasNext(): checks if there is another value in the list
	@Override
	public boolean hasNext() {
		
		return node != null;
	}

	//next(): returns current value and advances to next value
	@Override
	public E next() {
		if(node == null) {
			return null;
		}
		
		GenericList<E>.Node<E> temp = node;
		node = node.getNext();
		index++;
		return temp.getVal();
		
	}

	//hasNext(): checks if there is another value in the list
	@Override
	public boolean hasPrevious() {

		return node != null;
	}

	//previous(): returns current value and advances to next value
	// in reverse order
	@Override
	public E previous() {
		GenericList<E>.Node<E> temp = head;
		while(temp.getNext() != node &&(node != head)) {
			
			temp = temp.getNext();
		}
		E val = node.getVal();
		index--;
		if(node == head) {
			node = null;
		}else {
			node = temp;
		}
		return val;

	}
	
	// nextIndex(); returns index of next value;
	@Override
	public int nextIndex() {
		int nextIndex = index+1;
		return nextIndex;
	}

	// previousIndex(); returns index of previous value;
	@Override
	public int previousIndex() {
		int prevIndex = index-1;
		return prevIndex;
	}

	
	public void remove() {
	}
	

	
	public void set(E e) {
		// TODO Auto-generated method stub
		
	}

	
	public void add(E e) {
		// TODO Auto-generated method stub
		
	}

}
