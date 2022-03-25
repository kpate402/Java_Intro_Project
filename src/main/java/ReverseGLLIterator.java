import java.util.Iterator;

public class ReverseGLLIterator<E> implements Iterator<E> {
	private GenericList<E>.Node<E> node;
	private GenericList<E>.Node<E> head;
	
	// ReverseGLLIterator Constructor:
	ReverseGLLIterator(GenericList<E>.Node<E> Head) {
		
		node = Head;
		head = Head;
		while (node.getNext() != null) {
			
			node = node.getNext();
		}
	}

	//hasNext(): checks if there is another value in the list
	@Override
	public boolean hasNext() {

		return node != null;
	}

	//next(): returns current value and advances to next value
	//(since it starts at the end of the list next value is
	// previous)
	@Override
	public E next() {
		
		
		
		GenericList<E>.Node<E> temp = head;
		while(temp.getNext() != node &&(node != head)) {
			
			temp = temp.getNext();
		}
		E val = node.getVal();
		if(node == head) {
			node = null;
		}else {
			node = temp;
		}
		return val;

	}

}
