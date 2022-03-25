import java.util.Iterator;

public class GLLIterator<E> implements Iterator<E> {
	private GenericList<E>.Node<E> node;
	
	// GLLIterator Constructor:
	GLLIterator(GenericList<E>.Node<E> Head) {
		node = Head;
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
		return temp.getVal();

	}

}
