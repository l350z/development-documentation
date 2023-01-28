package cn.jbit.datastructure.util;

public class SingleLinkedList<E> implements LinearList<E> {

    private Node<E> head;  
	
	public SingleLinkedList(){
        this.head = null;
    }

    public SingleLinkedList(Node<E> head){
        this.head = head;
    }
	public boolean add(int index, E element) {
		if (index < 0)
	        throw new IndexOutOfBoundsException("Index: "+index);
		if (head == null)//头插入
            head = new Node<E>(element);
        else { 
        	int j=0; 
            Node<E> p=this.head;
            while (p.next != null && j < index-1){
                j++;
                p = p.next;
            }
            p.next = new Node<E>(element, p.next);//中间/尾插入
        }
        return true;
	}

	@Override
	public boolean add(E element) {
		return add(Integer.MAX_VALUE, element);
	}

	@Override
	public void clear() {
		head = null;		
	}

	@Override
	public E get(int index) {
		if (index < 0 || index > this.size())
	        throw new IndexOutOfBoundsException("Index: "+index);
		
        Node<E> p = head;
        for (int i = 0; i <= index; i++)
             p = p.next;
       	return (E)p.nodeValue;
       
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public E remove(int index) {
	   E old = null;
	   if (head != null && index >= 0)
	       if (index == 0){
	           old = (E)head.nodeValue;
	           head = head.next;
	       }
	       else{                                
	           int j=0; 
	           Node<E> p=this.head;
	           while (p.next != null && j < index-1){             
	               j++;
	               p = p.next;
	          }
	          if(p.next != null){
	               old = (E)p.next.nodeValue;
	               p.next = p.next.next;
	          }
	       }
	    return old;
	}

	@Override
	public E set(int index, E element) {
		if (index < 0 || index > this.size())
	        throw new IndexOutOfBoundsException("Index: "+index);
		
		Node<E> p = head;
        for (int i = 0; i <= index; i++)
           p = p.next;

        E old = (E)p.nodeValue;
        p.nodeValue = element;
        return old;                     

        
	}

	@Override
	public int size() {
		int size = 0; 
        Node<E> p = head;
        while (p != null){
            size++;
            p = p.next;
        }
        return size;
	}

}
