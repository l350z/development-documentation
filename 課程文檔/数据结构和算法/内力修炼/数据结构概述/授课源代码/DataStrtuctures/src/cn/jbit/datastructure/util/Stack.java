package cn.jbit.datastructure.util;

public interface Stack<E> {
	public void push(E iEem);
	public E pop();
	public E peek();
	public boolean isEmpty();
	public int size();
}
