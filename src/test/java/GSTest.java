import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import org.junit.jupiter.api.Test;

public class GSTest {
	public GenericStack<String> Stack;
	public GenericStack<String> Stack2;
	
	// test Constructor and see all values are assigned;
	@Test
	public void stackConstructor() {
		Stack = new GenericStack<String>("A");
		assertEquals("A",Stack.getTail().getVal(),"Wrong Tail");
		assertNull(Stack.getTail().getNext());
		assertEquals(1,Stack.getLength(),"Wrong Size");
		assertEquals("A",Stack.getHead().getVal(),"Wrong Head");
		assertNull(Stack.getHead().getNext());
	}
	
	// test Constructor and see all values are assigned;
	@Test
	public void stackConstructor2() {
		Stack = new GenericStack<String>("B");
		assertEquals("B",Stack.getTail().getVal(),"Wrong Tail");
		assertNull(Stack.getTail().getNext());
		assertNotEquals(2,Stack.getLength(),"Wrong Size");
		assertEquals("B",Stack.getHead().getVal(),"Wrong Head");
		assertNull(Stack.getHead().getNext());
	}
	
	// test node value getter
	@Test
	public void stackValGetter() {
		Stack = new GenericStack<String>("B");
		assertEquals("B", Stack.getTail().getVal());
	}
	
	// test node value setter;
	@Test
	public void stackValSetter() {
		Stack = new GenericStack<String>("B");
		Stack.getTail().setVal("A");
		assertEquals("A", Stack.getTail().getVal());
	}
	
	// test node next getter;
	@Test
	public void stackNextGetter() {
		Stack = new GenericStack<String>("B");
		assertNull(Stack.getTail().getNext());
		 
	}
	
	// test node next setter;
	@Test
	public void stackNextSetter() {
		Stack = new GenericStack<String>("B");
		GenericStack<String> Stack2 = new GenericStack<String>("C");
		Stack.getHead().setNext(Stack2.getHead());
		assertEquals(Stack2.getHead(),Stack.getHead().getNext(),"setNext not working");
	}
	
	// test getter for head
	@Test
	public void stackHeadGetter() {
		Stack = new GenericStack<String>("B");
		assertEquals("B", Stack.getHead().getVal());
	}
	
	//test setter for head
	@Test
	public void stackHeadSetter() {
		Stack = new GenericStack<String>("B");
		Stack.add("AA");
		Stack.add("CC");
		Stack.setHead(Stack.getHead().getNext());
		assertEquals("AA", Stack.getHead().getVal());
	}
	
	//test getter for tail
	@Test
	public void stackTailGetter() {
		Stack = new GenericStack<String>("B");
		assertEquals("B", Stack.getTail().getVal());
	}
	
	// test setter for tail
	@Test
	public void stackTailSetter() {
		Stack = new GenericStack<String>("B");
		Stack.add("AA");
		Stack.setTail(Stack.getHead());
		assertEquals("AA", Stack.getTail().getVal());
	}
	
	// test getter for length
	@Test
	public void stackLengthGetter() {
		Stack = new GenericStack<String>("B");
		assertEquals(1, Stack.getLength());
		Stack.add("A");
		Stack.add("C");
		Stack.add("D");
		assertEquals(4, Stack.getLength());
	}
	
	// test setter for length
	@Test
	public void stackLengthSetter() {
		Stack = new GenericStack<String>("B");
		Stack.setLength(10);
		assertEquals(10, Stack.getLength());
	}
	
	// test print function by comparing 2 stacks
	@Test
	public void testStackprint() {
		Stack = new GenericStack<String>("B");
		Stack.add("A");
		Stack.add("C");
		Stack.add("D");
		
		Stack2 = new GenericStack<String>("B");
		Stack2.add("A");
		Stack2.add("C");
		Stack2.add("D");
		
		System.out.println("Stack.print() : ");
		Stack.print();
		System.out.println("Stack2.print() : ");
		Stack2.print();
	}
	
	// test dumplist() method from GenericList
	@Test 
	public void stackDumpListTest() {
		Stack = new GenericStack<String>("B");
		Stack.add("A");
		Stack.add("C");
		Stack.add("D");
		
		ArrayList<String> x = new ArrayList<String>();
		x.add("D");
		x.add("C");
		x.add("A");
		x.add("B");
		ArrayList<String> list = Stack.dumpList();
		for(int i = 0; i < x.size(); i++ ) {
			assertEquals(x.get(i), list.get(i));
		}
	}
	
	// test delete() for stack
	@Test
	public void stackDeleteNode() {
		Stack = new GenericStack<String>("B");
		Stack.add("A");
		Stack.add("C");
		Stack.add("D");
		
		assertEquals("D", Stack.delete());
		assertEquals(3, Stack.getLength());
		assertEquals("C", Stack.getHead().getVal());
	}
	
	// test get() from GenericList
	@Test
	public void stackGet() {
		Stack = new GenericStack<String>("B");
		Stack.add("A");
		Stack.add("C");
		Stack.add("D");
		
		assertEquals("C", Stack.get(1));
		assertEquals("A", Stack.get(2));
		
	}
	
	// test set() from GenericList
	@Test
	public void stackSet() {
		Stack = new GenericStack<String>("B");
		Stack.add("A");
		Stack.add("C");
		Stack.add("D");
		Stack.set(1,"AA");
		Stack.set(2,"CC");
		assertEquals("AA", Stack.get(1));
		assertEquals("CC", Stack.get(2));
		
	}
	
	// Add() form GenericQueue()
	@Test
	public void stackAdd() {
		Stack = new GenericStack<String>("B");
		ArrayList<String> list = Stack.dumpList();
		Stack.add("A");
		assertEquals("A", Stack.getTail().getVal());
		assertEquals("A", Stack.getHead().getVal());
		assertEquals(1, Stack.getLength());
		Stack.add("C");
		assertEquals("A", Stack.getTail().getVal());
		assertEquals("C", Stack.getHead().getVal());
		assertEquals(2, Stack.getLength());
		Stack.add("D");
		assertEquals("A", Stack.getTail().getVal());
		assertEquals("D", Stack.getHead().getVal());
		assertEquals(3, Stack.getLength());
		
	}
	
	//test for removeTail() in GenericQueue
	@Test	
	public void stackRemoveTailTest() {
		Stack = new GenericStack<String>("B");
		Stack.add("A");
		Stack.add("C");
		Stack.add("D");
		
		assertEquals("B", Stack.removeTail());
		assertEquals(3, Stack.getLength());
		assertEquals("A", Stack.removeTail());
		assertEquals(2, Stack.getLength());
		assertEquals("C", Stack.removeTail());
		assertEquals(1, Stack.getLength());
		assertEquals("D", Stack.removeTail());
		assertEquals(0, Stack.getLength());
		assertNull(Stack.getHead());
		assertNull(Stack.getTail());
	}
	
	// enqueue() form GenericStack()
	@Test
	public void stackPushTest() {
		Stack = new GenericStack<String>("B");
		
		ArrayList<String> list = Stack.dumpList();
		Stack.push("AA");
		assertEquals("AA", Stack.getTail().getVal());
		assertEquals("AA", Stack.getHead().getVal());
		assertEquals(1, Stack.getLength());
		Stack.push("CC");
		assertEquals("AA", Stack.getTail().getVal());
		assertEquals("CC", Stack.getHead().getVal());
		assertEquals(2, Stack.getLength());
		Stack.push("DD");
		assertEquals("AA", Stack.getTail().getVal());
		assertEquals("DD", Stack.getHead().getVal());
		assertEquals(3, Stack.getLength());
			
	}
	
	// pop() from GenericStack();
	@Test
	public void stackPopTest() {
		Stack = new GenericStack<String>("BB");
		Stack.add("AA");
		Stack.add("CC");
		Stack.add("DD");
		
		assertEquals("DD", Stack.pop());
		assertEquals(3, Stack.getLength());
		assertEquals("CC", Stack.getHead().getVal());
	}
	
	// test hasNext() from GLLIterator();
	@Test
	public void stackIteratorHasNextTest() { 
		Stack = new GenericStack<String>("BB");
		Stack.add("AA");
		Stack.add("CC");
		Stack.add("DD");
		assertEquals(true,Stack.iterator().hasNext());
		
	}
	// test hasNext() from GLLIterator() using variable;
	@Test
	public void stackIteratorHasNextTest2() { 
		Stack = new GenericStack<String>("BB");
		Iterator<String> iter = Stack.iterator();
		Stack.add("AA");
		Stack.add("CC");
		Stack.add("DD");
		assertEquals(true,iter.hasNext());
			
	}
	
	// test next() from GLLIterator();
	@Test
	public void stackIteratorNextTest() { 
		Stack = new GenericStack<String>("BB");
		Stack.add("AA");
		Stack.add("CC");
		Stack.add("DD");
		assertEquals("DD",Stack.iterator().next());
	}
	// test next() from GLLIterator() using variable;
	@Test
	public void stackIteratorNextTest2() { 
		Stack = new GenericStack<String>("BB");
		Iterator<String> iter= Stack.iterator();
		Stack.add("AA");
		Stack.add("CC");
		Stack.add("DD");
		assertEquals("BB",iter.next());
	}
	
	// test iterator() from GenericList and test for each
	// Functionality
	@Test
	public void stackIteratorAndForEachLoop() {
		Stack = new GenericStack<String>("BB");
		Stack.add("AA");
		Stack.add("CC");
		Stack.add("DD");
		int i = 0;
		System.out.println("Iterator: forward iteration");
		//Iterator<String> iter = Stack.iterator();
		for(Iterator<String> iter = Stack.iterator(); iter.hasNext();) {
			String e = iter.next();
			System.out.println(e);	
			i++;
		}
		assertEquals(i, Stack.getLength());
		
	}
	
	// test hasNext() from ReverseGLLIterator() using variable;
	@Test
	public void stackReverseIteratorHasNextTest2() { 
		Stack = new GenericStack<String>("BB");
		Stack.add("AA");
		Stack.add("CC");
		Stack.add("DD");
		Iterator<String> iter = Stack.descendingIterator();
		assertEquals(true,iter.hasNext());
				
	}
	// test hasNext() from ReverseGLLIterator() using variable;
	@Test
	public void stackReverseIteratorNextTest() { 
		Stack = new GenericStack<String>("BB");
		Stack.add("AA");
		Stack.add("CC");
		Stack.add("DD");
		Iterator<String> iter = Stack.descendingIterator();
		assertEquals("BB",iter.next());
	}
	// test descendingIterator() from GenericList and check
	// for each functionality
	@Test
	public void stackDecendingIteratorAndForEachLoop() {
		Stack = new GenericStack<String>("BB");
		Stack.add("AA");
		Stack.add("CC");
		Stack.add("DD");
		int i = 0;
		System.out.println("decendingIterator: backward iteration");
		for(Iterator<String> iter = Stack.descendingIterator(); iter.hasNext();) {
			String e = iter.next();
			System.out.println(e);	
			i++;
		}
		assertEquals(i, Stack.getLength());
	}
	
	// test hasNext() from GLListIterator() 
	@Test
	public void stackListIteratorHasNextTest() { 
		Stack = new GenericStack<String>("BB");
		Stack.add("AA");
		Stack.add("CC");
		Stack.add("DD");
		ListIterator<String> iter = Stack.listIterator(2);
		assertEquals(true,iter.hasNext());
	}
	
	// test next() from GLListIterator() 
	@Test
	public void stackListIteratorNextTest() { 
		Stack = new GenericStack<String>("BB");
		Stack.add("AA");
		Stack.add("CC");
		Stack.add("DD");
		ListIterator<String> iter = Stack.listIterator(2);
		assertEquals("AA",iter.next());
	}
	
	// test nextIndex() from GLListIterator() 
	@Test
	public void stackListIteratorNextIndexTest() { 
		Stack = new GenericStack<String>("BB");
		Stack.add("AA");
		Stack.add("CC");
		Stack.add("DD");
		ListIterator<String> iter = Stack.listIterator(2);
		assertEquals(3,iter.nextIndex());
	}
	
	// test previousIndex() from GLListIterator() 
	@Test
	public void stackListIteratorPreviousIndexTest() { 
		Stack = new GenericStack<String>("BB");
		Stack.add("AA");
		Stack.add("CC");
		Stack.add("DD");
		ListIterator<String> iter = Stack.listIterator(2);
		assertEquals(1,iter.previousIndex());
	}
	
	// test hasPrevious() from GLListIterator() 
	@Test
	public void stackListIteratorHasPreviousTest() { 
		Stack = new GenericStack<String>("BB");
		Stack.add("AA");
		Stack.add("CC");
		Stack.add("DD");
		ListIterator<String> iter = Stack.listIterator(2);
		assertEquals(true,iter.hasPrevious());
	}
	
	// test previous() from GLListIterator() 
	@Test
	public void stackListIteratorPreviousTest() { 
		Stack = new GenericStack<String>("BB");
		Stack.add("AA");
		Stack.add("CC");
		Stack.add("DD");
		ListIterator<String> iter = Stack.listIterator(2);
		assertEquals("AA",iter.previous());
	}
	
	// test listIterator() from GenericList and check
	// for each functionality
		@Test
		public void stackListIteratorAndForEachLoop() {
			Stack = new GenericStack<String>("BB");
			Stack.add("AA");
			Stack.add("CC");
			Stack.add("DD");
			Stack.add("EE");
			Stack.add("FF");
			Stack.add("GG");
			
			System.out.println("ListIterator: forward iteration");
			for(ListIterator<String> iter = Stack.listIterator(3); iter.hasNext();) {
				String e = iter.next();
				System.out.println(e);	
				
			}
			
			System.out.println("ListIterator: backward iteration");
			for(ListIterator<String> iter = Stack.listIterator(3); iter.hasPrevious();) {
				String e = iter.previous();
				System.out.println(e);	
			}
		
	
		}


	
	
}
