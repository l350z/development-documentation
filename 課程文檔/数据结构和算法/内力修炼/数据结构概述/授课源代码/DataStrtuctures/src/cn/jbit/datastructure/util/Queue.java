package cn.jbit.datastructure.util;

public interface Queue<E> {
	   public void push(E item);

	   public E pop();

	   public E peek();

	   public boolean isEmpty();

	   public int size();
}
