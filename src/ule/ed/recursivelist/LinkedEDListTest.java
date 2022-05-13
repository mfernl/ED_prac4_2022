package ule.ed.recursivelist;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import org.junit.*;


public class LinkedEDListTest {
	private LinkedEDList<String> lista;
	
	@Before
	public void test() {
		 lista= new LinkedEDList<String>();
	}

	@Test
	public void test_Vacia() {
		assertEquals(0,lista.size());
	}
	
	@Test
	public void testSize() {
		lista.addLast("2");
		assertEquals(1,lista.size());
	}
	
	@Test
	public void testGetPosFirst() {
		lista.addLast("2");
		lista.addPos("A",2);
		lista.addPos("B",3);
		assertEquals(3,lista.getPosFirst("B"));
		assertEquals(2,lista.getPosFirst("A"));
		assertEquals(1,lista.getPosFirst("2"));
	}
	
	@Test
	public void testGetPosLast() {
		lista.addLast("2");
		lista.addPos("A",2);
		lista.addPos("B",3);
		lista.addLast("A");
		lista.addLast("B");
		lista.addLast("2");
		assertEquals(5,lista.getPosLast("B"));
		assertEquals(4,lista.getPosLast("A"));
		assertEquals(6,lista.getPosLast("2"));
	}
	
	@Test
	public void testAddPos() {
		lista.addLast("2");
		lista.addLast("B");
		lista.addPos("A",2);
		assertEquals("(2 A B )",lista.toString());
		assertEquals(3,lista.size());
		assertEquals("A",lista.getElemPos(2));
		assertEquals("B",lista.getElemPos(3));
	}
	
	@Test
	public void testAllRemove() throws EmptyCollectionException {
		lista.addLast("2");
		lista.addPos("A",2);
		lista.addPos("B",3);
		lista.addLast("A");
		assertEquals(4,lista.size());
		assertEquals("A",lista.removeFirstElem("A"));
		assertEquals(3,lista.size());
		assertEquals("B",lista.removePenult());
		assertEquals(2,lista.size());
		assertEquals("A",lista.removelast());
		assertEquals(1,lista.size());
	}
	
	@Test
	public void testRemoveFirst() throws EmptyCollectionException {
		lista.addLast("2");
		lista.addPos("A",2);
		assertEquals("(2 A )",lista.toString());
		assertEquals("A",lista.removeFirstElem("A"));
		assertEquals("(2 )",lista.toString());
		assertEquals(1,lista.size());
	}
	
	@Test
	public void testGetPosLastTest() throws EmptyCollectionException {
		lista.addLast("A");
		lista.addLast("B");
		lista.addLast("C");
		lista.addLast("D");
		lista.addLast("E");
		assertEquals("(A B C D E )",lista.toString());
		assertEquals(5,lista.getPosLast("E"));
	}
	
	@Test
	public void testGetPosLastDiffClass() throws EmptyCollectionException {
		lista.addLast("A");
		lista.addLast("B");
		lista.addLast("C");
		lista.addLast("D");
		lista.addLast("E");
		assertEquals("(A B C D E )",lista.toString());
		assertEquals(1,lista.getPosLast("A"));
	}
	
	@Test
	public void testRemovePenulUntil1() throws EmptyCollectionException {
		lista.addLast("2");
		lista.addPos("A",2);
		lista.addLast("B");
		lista.addLast("C");
		assertEquals("(2 A B C )",lista.toString());
		assertEquals("B",lista.removePenult());
		assertEquals("A",lista.removePenult());
		assertEquals("2",lista.removePenult());
		assertEquals("(C )",lista.toString());
		assertEquals(1,lista.size());
	}
	
	@Test
	public void testRemovelastElem() throws EmptyCollectionException {
		lista.addLast("B");
		lista.addPos("A",2);
		lista.addLast("2");
		lista.addLast("2");
		lista.addLast("2");
		assertEquals("(B A 2 2 2 )",lista.toString());
		assertEquals(5,lista.size());
		assertEquals("2",lista.removeLastElem("2"));
		assertEquals("(B A 2 2 )",lista.toString());
		assertEquals(4,lista.size());
		assertEquals("B",lista.removeLastElem("B"));
		assertEquals("(A 2 2 )",lista.toString());
		assertEquals(3,lista.size());
	}
	
	@Test
	public void testGetElemPos() throws EmptyCollectionException {
		lista.addLast("2");
		lista.addPos("A",2);
		lista.addPos("B",3);
		lista.addLast("A");
		assertEquals("B",lista.getElemPos(3));
		assertEquals(2,lista.getPosFirst("A"));		
	}
	
	@Test
	public void testReverse() throws EmptyCollectionException {
		lista.addLast("2");
		lista.addPos("A",2);
		lista.addPos("B",3);
		lista.addLast("2");
		lista.addLast("E");
		lista.addLast("G");
		assertEquals("(G E 2 B A 2 )",lista.reverse().toString());
	}
	
	@Test
	public void testFromUntilReverse() throws EmptyCollectionException {
		lista.addLast("2");
		lista.addPos("A",2);
		lista.addPos("B",3);
		lista.addLast("2");
		lista.addLast("C");
		lista.addLast("2");
		lista.addLast("2");
		assertEquals("(C 2 B A )",lista.toStringFromUntilReverse(5,2));
		assertEquals("()",lista.toStringFromUntilReverse(9,8));
		assertEquals("(2 )",lista.toStringFromUntilReverse(1,1));
	}
	
	@Test
	public void testEvenOdd() throws EmptyCollectionException {
		lista.addLast("2");
		lista.addPos("A",2);
		lista.addPos("B",3);
		lista.addLast("2");
		lista.addLast("E");
		lista.addLast("G");
		assertEquals("(A 2 G E B 2 )",lista.toStringEvenOdd());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testGetPosFirstNoElem() {
			lista.getPosFirst("C");
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testRemoveLastElemNoExiste() throws EmptyCollectionException{
		lista.addLast("A");	
		lista.removeLastElem("C");
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testRemoveFirstElemNoExiste() throws EmptyCollectionException{
		lista.addLast("A");	
		lista.removeFirstElem("C");
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testGetLastElemNoExiste() throws EmptyCollectionException{
		lista.addLast("A");	
		lista.getPosLast("C");
	}
	 
	@Test
	public void test_AddLast() {
		lista.addLast("2");
		Assert.assertFalse(lista.isEmpty());
		Assert.assertEquals("(2 )", lista.toString());
		lista.addLast("3");
		Assert.assertEquals("(2 3 )", lista.toString());
		lista.addLast("7");
		Assert.assertEquals("(2 3 7 )", lista.toString());
	}
	
	@Test
	public void testAddPosVarios() {
		lista.addLast("2");
		lista.addLast("3");
		lista.addLast("7");
		lista.addLast("3");
		lista.addLast("5");
		lista.addLast("10");
		lista.addPos("12", 4);
		assertEquals("(2 3 7 12 3 5 10 )",lista.toString());
	}
	
	@Test(expected=EmptyCollectionException.class)
	public void test_RemoveFirst_Vacia() throws EmptyCollectionException{
		lista.removeFirstElem("A");
	}

	@Test(expected=NullPointerException.class)
	public void test_addLast_ElementoNulo() {
			lista.addLast(null);
	}
	
	@Test
	public void linkedtestAddAntePenult_Varios() {
		lista.addLast("2");
		Assert.assertFalse(lista.isEmpty());
		Assert.assertEquals("(2 )", lista.toString());
		lista.addAntePenult("3");
		Assert.assertEquals("(3 2 )", lista.toString());
		lista.addAntePenult("7");
		Assert.assertEquals("(7 3 2 )", lista.toString());
		lista.addAntePenult("10");
		Assert.assertEquals("(7 10 3 2 )", lista.toString());
		
	}
	
	
	
}
