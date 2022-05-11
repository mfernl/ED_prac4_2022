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
		StringBuffer salida = new StringBuffer();
		StringBuffer texto = new StringBuffer();
			salida.append("(");
			salida.append(toStringRec(this.front,texto));
			salida.append(")");
		return salida.toString();
	}
	
	public String toStringRec(Node<T> aux, StringBuffer salida) {
		if(aux!=null) {
			salida.append(aux.elem + " ");
			toStringRec(aux.next,salida);
		}
		return salida.toString();
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
		}else if(front.next.next == null){
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
		if(aux.next.next.next!=null) {
			sig = aux.next;
			addAntePenRec(sig,elem);
		}else {
			sig = aux.next;
			Node<T> e = new Node<T>(elem);
			aux.next = e;
			e.next = sig;
		}
	}


	@Override
	public void addPos(T elem, int position) {
		if(elem == null) {
			throw new NullPointerException();
		}else if(position <= 0){
			throw new IllegalArgumentException();
		}else if(position>=size()) {
			addLast(elem);
		}else if(isEmpty()) {
			addLast(elem);
		}else if(position == 1) {
			Node<T> nuevo = new Node<T>(elem);
			Node<T> aux = front;
			front = nuevo;
			nuevo.next = aux;
		}else if(position>=size()) {
			addLast(elem);
		}else{
			addPosRec(this.front,elem,position);
		}
	}
	
	
	public void addPosRec(Node<T> aux, T elem ,int position) {
		int vuelta = position;
		if(aux != null) {
			Node<T> prev = aux;
			if(aux.next != null) {
				Node<T> current = aux.next;
				if(vuelta == 2) {
					Node<T> nuevo = new Node<T>(elem);
					prev.next = nuevo;
					nuevo.next = current;
				}else {
					addPosRec(current,elem,vuelta--);
				}
			}
		}
	}


	@Override
	public T getElemPos(int position) {
		if(1>position && position>size()) {
			throw new IllegalArgumentException();
		}else{	
			return getElemPosRec(this.front,position);
		}
	}

	public T getElemPosRec(Node<T> aux,int position) {
		Node <T> result;
		if(aux!=null) {
			if(position == 1) {
				result = aux;
				return result.elem;
			}else {
				 return getElemPosRec(aux.next,--position);
			}
		}else {
		return null;
		}
	}


	@Override
	public int getPosFirst(T elem) {
		if(elem == null) {
			throw new NullPointerException();
		}else {
			return getPosFirstRec(this.front,elem);
		}
	}

	public int getPosFirstRec(Node<T> aux, T elem) {
		int pos;
		if(aux!=null) {
			if(aux.elem.equals(elem)) {
				pos = 1;
			}else {
				pos = 1 + getPosFirstRec(aux.next,elem);
			}
		}else {
			pos = 0;
			throw new NoSuchElementException();
		}
		return pos;
	}

	@Override
	public int getPosLast(T elem) {
		if(elem == null) {
			throw new NullPointerException();
		}else {
			return getPosLastRec(this.front,elem);
		}
	}

	public int getPosLastRec(Node<T> aux, T elem) {
		int pos;
		if(aux!=null) {
			if(aux.elem.equals(elem)) {
				pos = 1;

			}else {
				pos = 1 + getPosLastRec(aux.next,elem);
			}
		}else {
			pos = 0;
			throw new NoSuchElementException();
		}
		return pos;
	}

	@Override
	public T removelast() throws EmptyCollectionException {
		T result;
		if (!isEmpty()){
			if (front.next == null){
				result=front.elem;
				front=null;
				return result;
			}else if(front.next.next == null) {
				result = front.next.elem;
				front.next = null;
				return result;
			}
			else return removeLastRec(front);
		}
		else { 
		throw new EmptyCollectionException("");
		}

	}
	
	public T removeLastRec(Node<T> aux) {
		T result;
		if(aux!=null) {
			if(aux.next.next == null) {
				result = aux.next.elem;
				aux.next = null;
				return result;
			}else {
				return removeLastRec(aux.next);
			}
		}
		else return null;
	}



	@Override
	public T removePenult() throws EmptyCollectionException {
		T result;
		if (!isEmpty()){
			if (front.next == null){
				throw new NoSuchElementException();
			}else if(front.next.next == null) {
				Node<T>aux = front;
				result = front.elem;
				front = aux.next;
				return result;
			}
			else return removePenultRec(front);
		}
		else { 
		throw new EmptyCollectionException("");
		}

	}
	
	public T removePenultRec(Node<T> aux) {
		T result;
		if(aux!=null) {
			if(aux.next.next.next == null) {
				result = aux.next.elem;
				aux.next = aux.next.next;
				return result;
			}else {
				return removeLastRec(aux.next);
			}
		}
		else return null;
	}


	public T removeFirstElem(T elem) throws EmptyCollectionException {
		if(isEmpty()) {
			throw new EmptyCollectionException("");
		}else if(front.elem.equals(elem)){
			T result;
			result = front.elem;
			front = front.next;
			return result;
		}else {	
			return removeFirstElemRec(this.front,elem);
		}
	}

	public T removeFirstElemRec(Node<T> aux, T elem) {
		T result;
		if(aux!=null) {
			if(aux.next.elem.equals(elem)) {
				result = aux.next.elem;
				aux.next = aux.next.next;
			}else {
				 result = removeFirstElemRec(aux.next,elem);
			}
		}else {
			throw new NoSuchElementException();
		}
		return result;
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
