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
	public void testAddPos() {
		lista.addLast("2");
		lista.addPos("A",2);
		lista.addPos("B",3);
		assertEquals(3,lista.size());
		assertEquals("A",lista.getElemPos(2));
		assertEquals("B",lista.getElemPos(3));
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testGetPosFirstNoElem() {
			lista.getPosFirst("C");
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
	
	// TODO  AÑADIR RESTO DE METODOS DE TESTS
	
	
}
