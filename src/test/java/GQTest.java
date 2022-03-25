import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import org.junit.jupiter.api.Test;

//import org.junit.jupiter.api.BeforeAll;

public class GQTest {

	public GenericQueue<String> Queue;
	public GenericQueue<String> Queue2;
	
	
	// test Constructor and see all values are assigned;
	@Test
	public void queueConstructor() {
		Queue = new GenericQueue<String>("A");
		assertEquals("A",Queue.getTail().getVal(),"Wrong Tail");
		assertNull(Queue.getTail().getNext());
		assertEquals(1,Queue.getLength(),"Wrong Size");
		assertEquals("A",Queue.getHead().getVal(),"Wrong Head");
		assertNull(Queue.getHead().getNext());
	}
	
	// test Constructor and see all values are assigned;
	@Test
	public void queueConstructor2() {
		Queue = new GenericQueue<String>("B");
		assertEquals("B",Queue.getTail().getVal(),"Wrong Tail");
		assertNull(Queue.getTail().getNext());
		assertNotEquals(2,Queue.getLength(),"Wrong Size");
		assertEquals("B",Queue.getHead().getVal(),"Wrong Head");
		assertNull(Queue.getHead().getNext());
	}
	
	// test node value getter
	@Test
	public void queueValGetter() {
		Queue = new GenericQueue<String>("B");
		assertEquals("B", Queue.getTail().getVal());
	}
	
	// test node value setter;
	@Test
	public void queueValSetter() {
		Queue = new GenericQueue<String>("B");
		Queue.getTail().setVal("A");
		assertEquals("A", Queue.getTail().getVal());
	}
	
	// test node next getter;
	@Test
	public void queueNextGetter() {
		Queue = new GenericQueue<String>("B");
		assertNull(Queue.getTail().getNext());
		 
	}
	
	// test node next setter;
	@Test
	public void queueNextSetter() {
		Queue = new GenericQueue<String>("B");
		GenericQueue<String> Queue2 = new GenericQueue<String>("C");
		Queue.getHead().setNext(Queue2.getHead());
		assertEquals(Queue2.getHead(),Queue.getHead().getNext(),"setNext not working");
	}
	
	// test getter for head
	@Test
	public void queueHeadGetter() {
		Queue = new GenericQueue<String>("B");
		assertEquals("B", Queue.getHead().getVal());
	}
	
	//test setter for head
	@Test
	public void queueHeadSetter() {
		Queue = new GenericQueue<String>("B");
		Queue.add("AA");
		Queue.setHead(Queue.getHead().getNext());
		assertEquals("AA", Queue.getHead().getVal());
	}
	
	//test getter for tail
	@Test
	public void queueTailGetter() {
		Queue = new GenericQueue<String>("B");
		assertEquals("B", Queue.getTail().getVal());
	}
	
	// test setter for tail
	@Test
	public void queueTailSetter() {
		Queue = new GenericQueue<String>("B");
		Queue.add("AA");
		Queue.setTail(Queue.getHead());
		assertEquals("B", Queue.getTail().getVal());
	}
	
	// test getter for length
	@Test
	public void queueLengthGetter() {
		Queue = new GenericQueue<String>("B");
		assertEquals(1, Queue.getLength());
		Queue.add("A");
		Queue.add("C");
		Queue.add("D");
		assertEquals(4, Queue.getLength());
	}
	
	// test setter for length
	@Test
	public void queueLengthSetter() {
		Queue = new GenericQueue<String>("B");
		Queue.setLength(10);
		assertEquals(10, Queue.getLength());
	}
	
	// test print function by comparing 2 queues
	@Test
	public void testQueueprint() {
		Queue = new GenericQueue<String>("B");
		Queue.add("A");
		Queue.add("C");
		Queue.add("D");
		
		Queue2 = new GenericQueue<String>("B");
		Queue2.add("A");
		Queue2.add("C");
		Queue2.add("D");
		
		System.out.println("Queue.print() : ");
		Queue.print();
		System.out.println("Queue2.print() : ");
		Queue2.print();
	}
	
	// test dumplist() method from GenericList
	@Test 
	public void queueDumpListTest() {
		Queue = new GenericQueue<String>("B");
		Queue.add("A");
		Queue.add("C");
		Queue.add("D");
		
		ArrayList<String> x = new ArrayList<String>();
		x.add("B");
		x.add("A");
		x.add("C");
		x.add("D");
		ArrayList<String> list = Queue.dumpList();
		for(int i = 0; i < x.size(); i++ ) {
			assertEquals(x.get(i), list.get(i));
		}
	}
	
	// test delete() for queue
	@Test
	public void queueDeleteNode() {
		Queue = new GenericQueue<String>("B");
		Queue.add("A");
		Queue.add("C");
		Queue.add("D");
		
		assertEquals("B", Queue.delete());
		assertEquals(3, Queue.getLength());
		assertEquals("A", Queue.getHead().getVal());
	}
	
	// test get() from GenericList
	@Test
	public void queueGet() {
		Queue = new GenericQueue<String>("B");
		Queue.add("A");
		Queue.add("C");
		Queue.add("D");
		
		assertEquals("A", Queue.get(1));
		assertEquals("C", Queue.get(2));
		
	}
	
	// test set() from GenericList
	@Test
	public void queueSet() {
		Queue = new GenericQueue<String>("B");
		Queue.add("A");
		Queue.add("C");
		Queue.add("D");
		Queue.set(1,"AA");
		Queue.set(2,"CC");
		assertEquals("AA", Queue.get(1));
		assertEquals("CC", Queue.get(2));
		
	}
	// Add() form GenericQueue()
	@Test
	public void queueAdd() {
		Queue = new GenericQueue<String>("B");
		ArrayList<String> list = Queue.dumpList();
		Queue.add("A");
		assertEquals("A", Queue.getTail().getVal());
		assertEquals("A", Queue.getHead().getVal());
		assertEquals(1, Queue.getLength());
		Queue.add("C");
		assertEquals("C", Queue.getTail().getVal());
		assertEquals("A", Queue.getHead().getVal());
		assertEquals(2, Queue.getLength());
		Queue.add("D");
		assertEquals("D", Queue.getTail().getVal());
		assertEquals("A", Queue.getHead().getVal());
		assertEquals(3, Queue.getLength());
		
	}
	//test for removeTail() in GenericQueue
	@Test	
	public void queueRemoveTailTest() {
		Queue = new GenericQueue<String>("B");
		Queue.add("A");
		Queue.add("C");
		Queue.add("D");
		
		assertEquals("D", Queue.removeTail());
		assertEquals(3, Queue.getLength());
		assertEquals("C", Queue.removeTail());
		assertEquals(2, Queue.getLength());
		assertEquals("A", Queue.removeTail());
		assertEquals(1, Queue.getLength());
		assertEquals("B", Queue.removeTail());
		assertEquals(0, Queue.getLength());
		assertNull(Queue.getHead());
		assertNull(Queue.getTail());
	}
	
	// enqueue() form GenericQueue()
	@Test
	public void queueEnqueueTest() {
		Queue = new GenericQueue<String>("B");
		
		ArrayList<String> list = Queue.dumpList();
		Queue.enqueue("AA");
		assertEquals("AA", Queue.getTail().getVal());
		assertEquals("AA", Queue.getHead().getVal());
		assertEquals(1, Queue.getLength());
		Queue.enqueue("CC");
		assertEquals("CC", Queue.getTail().getVal());
		assertEquals("AA", Queue.getHead().getVal());
		assertEquals(2, Queue.getLength());
		Queue.enqueue("DD");
		assertEquals("DD", Queue.getTail().getVal());
		assertEquals("AA", Queue.getHead().getVal());
		assertEquals(3, Queue.getLength());
			
	}
	
	// dequeue() from GenericQueue();
	@Test
	public void queueDequeueTest() {
		Queue = new GenericQueue<String>("BB");
		Queue.add("AA");
		Queue.add("CC");
		Queue.add("DD");
		
		assertEquals("BB", Queue.dequeue());
		assertEquals(3, Queue.getLength());
		assertEquals("AA", Queue.getHead().getVal());
	}
	// test hasNext() from GLLIterator();
	@Test
	public void queueIteratorHasNextTest() { 
		Queue = new GenericQueue<String>("BB");
		Queue.add("AA");
		Queue.add("CC");
		Queue.add("DD");
		assertEquals(true,Queue.iterator().hasNext());
		
	}
	// test hasNext() from GLLIterator() using variable;
	@Test
	public void queueIteratorHasNextTest2() { 
		Queue = new GenericQueue<String>("BB");
		Iterator<String> iter = Queue.iterator();
		Queue.add("AA");
		Queue.add("CC");
		Queue.add("DD");
		assertEquals(true,iter.hasNext());
			
	}
	
	// test next() from GLLIterator();
	@Test
	public void queueIteratorNextTest() { 
		Queue = new GenericQueue<String>("BB");
		Queue.add("AA");
		Queue.add("CC");
		Queue.add("DD");
		assertEquals("BB",Queue.iterator().next());
	}
	// test next() from GLLIterator() using variable;
	@Test
	public void queueIteratorNextTest2() { 
		Queue = new GenericQueue<String>("BB");
		Iterator<String> iter= Queue.iterator();
		Queue.add("AA");
		Queue.add("CC");
		Queue.add("DD");
		assertEquals("BB",iter.next());
	}
	
	// test iterator() from GenericList and test for each
	// Functionality
	@Test
	public void queueIteratorAndForEachLoop() {
		Queue = new GenericQueue<String>("BB");
		Queue.add("AA");
		Queue.add("CC");
		Queue.add("DD");
		int i = 0;
		System.out.println("Iterator: forward iteration");
		//Iterator<String> iter = Queue.iterator();
		for(Iterator<String> iter = Queue.iterator(); iter.hasNext();) {
			String e = iter.next();
			System.out.println(e);	
			i++;
		}
		assertEquals(i, Queue.getLength());
		
	}
	
	// test hasNext() from ReverseGLLIterator() using variable;
	@Test
	public void queueReverseIteratorHasNextTest2() { 
		Queue = new GenericQueue<String>("BB");
		Queue.add("AA");
		Queue.add("CC");
		Queue.add("DD");
		Iterator<String> iter = Queue.descendingIterator();
		assertEquals(true,iter.hasNext());
				
	}
	// test hasNext() from ReverseGLLIterator() using variable;
	@Test
	public void queueReverseIteratorNextTest() { 
		Queue = new GenericQueue<String>("BB");
		Queue.add("AA");
		Queue.add("CC");
		Queue.add("DD");
		Iterator<String> iter = Queue.descendingIterator();
		assertEquals("DD",iter.next());
	}
	// test descendingIterator() from GenericList and check
	// for each functionality
	@Test
	public void queueDecendingIteratorAndForEachLoop() {
		Queue = new GenericQueue<String>("BB");
		Queue.add("AA");
		Queue.add("CC");
		Queue.add("DD");
		int i = 0;
		System.out.println("decendingIterator: backward iteration");
		for(Iterator<String> iter = Queue.descendingIterator(); iter.hasNext();) {
			String e = iter.next();
			System.out.println(e);	
			i++;
		}
		assertEquals(i, Queue.getLength());
	}
	
	// test hasNext() from GLListIterator() 
	@Test
	public void queueListIteratorHasNextTest() { 
		Queue = new GenericQueue<String>("BB");
		Queue.add("AA");
		Queue.add("CC");
		Queue.add("DD");
		ListIterator<String> iter = Queue.listIterator(2);
		assertEquals(true,iter.hasNext());
	}
	
	// test next() from GLListIterator() 
	@Test
	public void queueListIteratorNextTest() { 
		Queue = new GenericQueue<String>("BB");
		Queue.add("AA");
		Queue.add("CC");
		Queue.add("DD");
		ListIterator<String> iter = Queue.listIterator(2);
		assertEquals("CC",iter.next());
	}
	
	// test nextIndex() from GLListIterator() 
	@Test
	public void queueListIteratorNextIndexTest() { 
		Queue = new GenericQueue<String>("BB");
		Queue.add("AA");
		Queue.add("CC");
		Queue.add("DD");
		ListIterator<String> iter = Queue.listIterator(2);
		assertEquals(3,iter.nextIndex());
	}
	
	// test previousIndex() from GLListIterator() 
	@Test
	public void queueListIteratorPreviousIndexTest() { 
		Queue = new GenericQueue<String>("BB");
		Queue.add("AA");
		Queue.add("CC");
		Queue.add("DD");
		ListIterator<String> iter = Queue.listIterator(2);
		assertEquals(1,iter.previousIndex());
	}
	
	// test hasPrevious() from GLListIterator() 
	@Test
	public void queueListIteratorHasPreviousTest() { 
		Queue = new GenericQueue<String>("BB");
		Queue.add("AA");
		Queue.add("CC");
		Queue.add("DD");
		ListIterator<String> iter = Queue.listIterator(2);
		assertEquals(true,iter.hasPrevious());
	}
	
	// test previous() from GLListIterator() 
	@Test
	public void queueListIteratorPreviousTest() { 
		Queue = new GenericQueue<String>("BB");
		Queue.add("AA");
		Queue.add("CC");
		Queue.add("DD");
		ListIterator<String> iter = Queue.listIterator(2);
		assertEquals("CC",iter.previous());
	}
	
	// test listIterator() from GenericList and check
	// for each functionality
		@Test
		public void queueListIteratorAndForEachLoop() {
			Queue = new GenericQueue<String>("BB");
			Queue.add("AA");
			Queue.add("CC");
			Queue.add("DD");
			Queue.add("EE");
			Queue.add("FF");
			Queue.add("GG");
			
			System.out.println("ListIterator: forward iteration");
			for(ListIterator<String> iter = Queue.listIterator(3); iter.hasNext();) {
				String e = iter.next();
				System.out.println(e);	
				
			}
			
			System.out.println("ListIterator: backward iteration");
			for(ListIterator<String> iter = Queue.listIterator(3); iter.hasPrevious();) {
				String e = iter.previous();
				System.out.println(e);	
			}
		}
	
}
