package cn.jbit.datastructure.util;

import java.util.EmptyStackException;

public class SequenceStack<E> implements Stack<E> {

	private SequenceList<E> stackList = null;
	
	public SequenceStack(){
	      stackList = new SequenceList<E>();
	   }
	
	public boolean isEmpty() {
		return stackList.isEmpty();
	}

	public E peek() {
		if (isEmpty())
	         throw new EmptyStackException();

	    return stackList.get(stackList.size()-1);
	}

	public E pop() {
		if (isEmpty())
	         throw new EmptyStackException();

	    return stackList.remove(stackList.size()-1);
	}

	public void push(E item) {
		stackList.add(item);		
	}

	public int size() {
		return stackList.size();
	}


}
