package cn.jbit.datastructure.util;

public class Node<T> {
	
	   public T nodeValue;
	  
	   public Node<T> next;

	   public  Node() {
	      nodeValue = null;
	      next = null;
	   }

	   public Node(T item){
	      nodeValue = item;
	      next = null;
	   }
       //构造结点，指定数据元素和后继结点
	   public Node(T item, Node<T> next){
	        this.nodeValue = item;
	        this.next = next;
	   }
}
