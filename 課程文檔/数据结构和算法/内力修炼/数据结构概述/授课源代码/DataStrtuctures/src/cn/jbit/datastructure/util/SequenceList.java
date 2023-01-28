package cn.jbit.datastructure.util;

import java.util.Arrays;

public class SequenceList<E> implements LinearList<E> {

	private Object[] sList;//对象数组
	private int size;//顺序表长度
	    
	public SequenceList(int capacity){
	   if(capacity <= 0) this.sList = new Object[10];
	   this.sList = new Object[capacity];  
	   this.size = 0;
	}
	public SequenceList(){
	   this(10);
	}

	public boolean isEmpty(){                                           
	   return size==0;
	}

	public int size(){
	   return size;
	}

	public E get(int index){                                          
		rangeCheck(index);
	    return (E)sList[index]; 
	}

	public E set(int index, E element){                                            
		rangeCheck(index);
		E old = (E) sList[index];
		sList[index] = element;
		return old;
	}

	public boolean add(int index, E element){
		if (index > size || index < 0)
		    throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
		if(size==sList.length){
			//sList = Arrays.copyOf(sList, size*3/2+1);			
	        Object[] temp = sList;         
	        this.sList = new Object[temp.length*2];//重新申请一个容量更大的数组
	        for(int i = 0; i < temp.length; i++)//复制数组元素
	            this.sList[i] = temp[i];
	    }
		//System.arraycopy(sList, index, sList, index + 1,size - index);
	    for(int j = size-1; j >= index; j--)//元素后移
	        sList[j+1] = sList[j];
	    sList[index] = element;
	    size++;
	    return true;
	}

	public boolean add(E element){
	    return add(size, element);
	}
	    
	public E remove(int index){  
	    rangeCheck(index);
	    E old = (E)this.sList[index];
	    /*int numMoved = size - index - 1;
		if (numMoved > 0)
		    System.arraycopy(sList, index+1, sList, index,numMoved);*/
	    for(int j = index; j < size-1; j++)
	    	sList[j] = sList[j+1];
	    sList[--size] = null;
	    return old;	   
	}

	public void clear(){
	    if(size!=0){
	        for(int i = 0; i < size; i++)
	            this.sList[i] = null;
	       size=0;
	    }
	}	
	
	private void rangeCheck(int index) {
	    if (index >= size)
	    	throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
	}
}
