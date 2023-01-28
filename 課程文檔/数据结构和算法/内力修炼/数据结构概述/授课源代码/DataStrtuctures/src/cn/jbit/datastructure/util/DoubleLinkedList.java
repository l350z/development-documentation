package cn.jbit.datastructure.util;

import java.util.NoSuchElementException;

public class DoubleLinkedList<E> implements LinearList<E> {

	private DoubleNode<E> header;	
	private int size=0;        //³¤¶È
	public DoubleLinkedList()	{
		header = new DoubleNode<E>();
	}
	public boolean add(int index, E element) {
		// TODO Auto-generated method stub
		int i=0;
		DoubleNode<E> curr;
		for (curr = header.next; curr != header; curr = curr.next){
			i++;
			if (index==i)
				break;
		}
		addBefore(curr,element);
		return false;
	}

	public boolean add(E element) {
		// TODO Auto-generated method stub
		addLast(element);
		return true;
	}

	public void addLast(E item) {
	    addBefore(header,item);
	}
	
	public void addFirst(E item){

	   addBefore(header.next,item);
	}
	public void clear() {
		// TODO Auto-generated method stub
		if(size!=0){
			header.next=header;
			header.prev=header;
			size=0;
		}
	}

	public E get(int index) {
		// TODO Auto-generated method stub
		int i=0;
		DoubleNode<E> curr;

		// search for item
		for (curr = header.next; curr != header; curr = curr.next){
			i++;
			if (index==i)
				break;
		}
		return curr.nodeValue;
	}

	public E getFirst(){
		if (this.size() == 0)
			throw new NoSuchElementException();
		return header.next.nodeValue;
	}

	public E getLast()	{
		if (this.size() == 0)
			throw new NoSuchElementException();
		return header.prev.nodeValue;
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	public E remove(int index) {
		// TODO Auto-generated method stub
		int i=0;
		DoubleNode<E> curr;
		for (curr = header.next; curr != header; curr = curr.next){
			i++;
			if (index==i)
				break;
		}
		remove(curr);
		return curr.nodeValue;
	}

	private boolean remove(DoubleNode<E> item)	{
		boolean retValue = false;
		DoubleNode<E> curr;

		// search for item
		for (curr = header.next; curr != header; curr = curr.next){
			if (item.nodeValue.equals(curr.nodeValue))
				break;
		}
		if (curr != header){
			retValue = true;
			curr.prev.next = curr.next;
			curr.next.prev = curr.prev;
		}
		size--;
		return retValue;
	}
	
	public E removeFirst()
	{
		if (size == 0)
			throw new NoSuchElementException("LinkedList removeFirst(): list empty");

		E first = header.next.nodeValue;
		remove(header.next);
		return first;
	}

	public E removeLast(){
		if (this.size() == 0)
			throw new NoSuchElementException("LinkedList removeLast(): list empty");

		E last = header.prev.nodeValue;
		remove(header.prev);
		return last;
	}
	
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	private DoubleNode<E> addBefore(DoubleNode<E> curr, E item)
	{
		DoubleNode<E> newNode, prevNode;

		newNode = new DoubleNode<E>(item);

		prevNode = curr.prev;

		newNode.prev = prevNode;
		newNode.next = curr;

		prevNode.next = newNode;
		curr.prev = newNode;
		size++;
		return newNode;
	}

}
