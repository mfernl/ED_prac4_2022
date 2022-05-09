package ule.ed.recursivelist;

import java.util.NoSuchElementException;


public class LinkedEDList<T> implements EDList<T> {

	//	referencia al primer  de la lista
	private Node<T> front;

	

	private class Node<T> {

		Node(T element) {
			this.elem = element;
			this.next = null;
		}

		T elem;

		Node<T> next;
	}



	@Override
	public int size() {
		int tamaño = sizeRec(this.front);
		return tamaño;
	}

	
	public int sizeRec(Node<T> aux) {
		int result;
		if(aux == null) {
			 result = 0;
		}else if(aux.next == null) {
			result = 1;
		}else {
			result = 1 + sizeRec(aux.next); 		
		}
		return result;
	}


	@Override
	public boolean isEmpty() {
		return front == null;
	}



	@Override
	public void addLast(T elem) {
		if(elem == null) {
			throw new NullPointerException();
		}else if(isEmpty()) {
			Node<T> aux = new Node<T>(elem);
			front = aux;
		}else {
			addLastRec(front,elem);
		}
	}

	public void addLastRec(Node<T> aux,T elem) {
		Node<T> sig;
		if(aux != null) {
			if(aux.next != null) {
				sig = aux.next;
				addLastRec(sig,elem);
			}else {
				Node<T> last = new Node<T>(elem);
				aux.next = last;
			}
		}
	}
	
	@Override
	public String toString() {
		// TODO RECURSIVAMENTE
	
		return null;
	}

	@Override
	public void addAntePenult(T elem) {
		if(elem == null) {
			throw new NullPointerException();
		}else if(isEmpty()) {
			Node<T> aux = new Node<T>(elem);
			front = aux;
		}else if(front.next == null){
			Node<T> a = new Node<T>(elem);
			Node<T> aux;
			aux = front;
			front = a;
			a.next = aux;
		}else {
			addAntePenRec(front,elem);
		}
	}

	
	public void addAntePenRec(Node<T> aux, T elem) {
		Node<T> sig;
		if(aux!=null) {
			if(aux.next!=null) {
				if(aux.next.next!=null) {
					Node<T> a = new Node<T>(elem);
					Node<T> e;
					sig = aux.next;
					
				}
			}
		}
	}


	@Override
	public void addPos(T elem, int position) {
		// TODO RECURSIVAMENTE
		
	}


	@Override
	public T getElemPos(int position) {
		// TODO RECURSIVAMENTE
		return null;
	}



	@Override
	public int getPosFirst(T elem) {
		// TODO RECURSIVAMENTE
		return 0;
	}



	@Override
	public int getPosLast(T elem) {
		// TODO RECURSIVAMENTE
		return 0;
	}



	@Override
	public T removelast() throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		return null;
	}



	@Override
	public T removePenult() throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		return null;
	}



	@Override
	public T removeFirstElem(T elem) throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		return null;
	}



	@Override
	public T removeLastElem(T elem) throws EmptyCollectionException {
		// TODO RECURSIVAMENTE
		return null;
	}



	@Override
	public EDList<T> reverse() {
		// TODO RECURSIVAMENTE
		return null;
	}



	@Override
	public String toStringFromUntilReverse(int from, int until) {
		// TODO RECURSIVAMENTE
		return null;
	}



	@Override
	public String toStringEvenOdd() {
		// TODO RECURSIVAMENTE
		return null;
	}
	
	
	
	
}
