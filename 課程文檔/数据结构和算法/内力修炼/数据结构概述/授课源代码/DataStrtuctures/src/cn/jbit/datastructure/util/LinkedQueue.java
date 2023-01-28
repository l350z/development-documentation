package cn.jbit.datastructure.util;

import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {
	private DoubleLinkedList<E> qlist = null;

	public LinkedQueue (){
	    qlist = new DoubleLinkedList<E>();
	}
	public void push(E item) {
		qlist.add(item);
	}
	public E pop() {
		if (isEmpty())
	         throw new NoSuchElementException ("LinkedQueue pop(): queue empty");
	    return qlist.removeFirst();
	}
	public E peek(){
		if (isEmpty())
	         throw new NoSuchElementException ("LinkedQueue front(): queue empty");

	      return qlist.getFirst();
	}
	public boolean isEmpty(){
		return qlist.isEmpty();
	}
	public int size(){
		return qlist.size();
	}

}
